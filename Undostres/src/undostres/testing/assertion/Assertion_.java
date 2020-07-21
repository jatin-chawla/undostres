package undostres.testing.assertion;

import undostres.testing.utilities.Getlogs;

public class Assertion_ {
	
		public static boolean checkequal( String Actual_result)
		{
			if (Actual_result.equals("¡Exitosa!"))
					{
				System.out.println("Payment passed");
				Getlogs.logscapture("Payment", "test case passed ");
				return true;
					}
			else
			{
				System.out.println("fail");
				Getlogs.logscapture("Payment Failes", "test case failed ");
				 return false;
			}
		}

	}

