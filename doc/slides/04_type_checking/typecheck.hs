data Exp = Number Int
         | Var Char
         | AOp Exp Exp
         | Deref Exp
         | Ref Exp
         | Cast Type Exp
         | Arr Exp Exp
         | Field Exp String
         | App Char [Exp] deriving (Show, Eq)

data Type = TInt
          | TPtr Type
          | TArr Type
          | TStruct [(Type,String)]
          | TFun (Type, [Type])
            deriving (Show, Eq)

-- *a[f(b->c)]*2
e1 =  AOp
        (Deref
           (Arr
               (Var 'a')
               (App 'f' [Field (Deref (Var 'b')) "c"])
               )
        )
        (Number 2)
e2 =         (Deref
           (Arr
               (Var 'a')
               (App 'f' [Field (Deref (Var 'b')) "c"])
               )
        )


-- type definitions slide 7/15
t_list = TStruct [(TInt,"info"),(TPtr t_list, "next")]
t_f = TFun (TInt, [t_list])
t_b = TStruct [(TPtr t_list, "c")]
t_a = TArr (TPtr TInt)

-- ensuing type environment
gamma = [('a',t_a), ('f',t_f), ('b',t_b)]

check env (Number _) = TInt
check env (Var x) = let Just t = lookup x env
                    in t
check env (AOp e1 e2) = let TInt = check env e1
                            TInt = check env e2
                        in  TInt
check env (Deref e) = let TPtr t = check env e in t
check env (Ref e)   = TPtr (check env e)
check env (Cast t e) = if cast_works t (check env e)
                       then t else error "cast"
check env (Arr e1 e2) = let TInt = check env e2
                        in case check env e1 of
                             TArr t  -> t
                             TPtr t -> t
                             _  -> error "Array"
check env (Field e s) = let TStruct fields = check env e
                            Just t = lookup s (map (\(x,y) -> (y,x)) fields)
                        in t
check env (App f args) = let argtypes = map (check env) args
                             Just (TFun (t,paramtypes)) = lookup f env
                         in if (paramtypes==argtypes) then t else error "Call"
cast_works _ _ = True
