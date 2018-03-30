package src;

import src.bin.C0;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;


class TestMain
{
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_BLACK = "\u001B[30m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_BLUE = "\u001B[34m";
  public static final String ANSI_PURPLE = "\u001B[35m";
  public static final String ANSI_CYAN = "\u001B[36m";
  public static final String ANSI_WHITE = "\u001B[37m";

  //This program awaits up to 3 string parameters
  //parameter 1 is required and is the filter for the tests to be run. It's matched against the relative path inside the testfiles folder
  // The only supported metacharacter is the wildcard "*"
  //parameter 2 is optional and is the string "cma" if all the steps from the cma execution are displayed
  //parameter 2 is optional and is the string "print" if every debug output except from the cma is displayed
  public static void main(String args[]) {

    String filter = args[0].replaceAll("[*]", ".*");
    filter += "c0";

    try
    {
      //Get names of all files
      ArrayList<File> files2 = new ArrayList<>();
      ArrayList<String> failedTests = new ArrayList<>();
      listf("testfiles",files2);

      final long startTime = System.currentTimeMillis();


      //Call the parser if the filename matches the filter
      for (File item : files2) {
        String relativePath = item.getParentFile().getName() + "/" + item.getName();
        if (relativePath.matches(filter)) {
          System.out.println("Executing test: " + relativePath);
          args[0] = item.toString();
          int returnCode =C0.runTest(args);
          System.out.println("Return code is " + returnCode);

          int minReturnToPass = Integer.parseInt(relativePath.substring(0,2));
          boolean shouldPass = relativePath.contains("_pass_");

          // should pass and passed -- OK
          if(shouldPass && returnCode == 0)
          {
            System.out.println(ANSI_GREEN + "Test passed as planned" + ANSI_RESET);
          }
          // should pass and failed - failed in the stage -- NOT OK
          else if(shouldPass && returnCode == (minReturnToPass -1))
          {
            System.out.println(ANSI_RED + "Test should have passed but did not!" + ANSI_RESET);
            failedTests.add(relativePath);
          }
          //                        - failed after the stage -- OK
          else if(shouldPass && returnCode >= (minReturnToPass ))
          {
            System.out.println(ANSI_GREEN + "Test passed as planned despite returning an error code. It failed in some stage which was out of the scope of this test" + ANSI_RESET);
          }
          // should fail and pass -- NOT OK
          else if(!shouldPass && returnCode == 0)
          {
            System.out.println(ANSI_RED + "Test should have failed but did pass for some reason!" + ANSI_RESET);
            failedTests.add(relativePath);
          }
          // should fail and fail - failed in the stage-- OK
          else if(!shouldPass && returnCode > minReturnToPass)
          {
            System.out.println(ANSI_GREEN + "Test failed as planned" + ANSI_RESET);
          }
          // should fail and fail - failed too early --NOT OK
          else if(!shouldPass && returnCode < minReturnToPass)
          {
            System.out.println(ANSI_RED + "Test failed too early! Missing a test to cover some bug in an earlier stage!" + ANSI_RESET);
            failedTests.add(relativePath);
          }
        }
      }


      final long endTime = System.currentTimeMillis();
      System.out.println("Total testing time: " + (endTime - startTime) + "milliseconds");
      if(failedTests.size() != 0)
      {
        System.out.println(ANSI_RED + "Following tests failed:");
        for (String item :
                failedTests) {
          System.out.println(item);
        }
        System.out.println(ANSI_RESET);
      }
      else
      {
        System.out.println(ANSI_GREEN + "All tests passed" + ANSI_RESET);
      }
    }
    catch(Exception e)
    {
      
    }
  }

  public static void listf(String directoryName, ArrayList<File> files) {
    File directory = new File(directoryName);

    // get all the files from a directory
    File[] fList = directory.listFiles();
    for (File file : fList) {
      if (file.isFile()) {
        files.add(file);
      } else if (file.isDirectory()) {
        listf(file.getAbsolutePath(), files);
      }
    }
  }
}