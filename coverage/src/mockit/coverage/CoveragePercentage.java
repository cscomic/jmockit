/*
 * Copyright (c) 2006-2011 Rogério Liesenfeld
 * This file is subject to the terms of the MIT license (see LICENSE.txt).
 */
package mockit.coverage;

public final class CoveragePercentage
{
   public static int calculate(int coveredCount, int totalCount)
   {
     if (totalCount <= 0)
       return -1;
     else
        return (coveredCount * 100/totalCount);
   }

   public static String percentageColor(int coveredCount, int totalCount)
   {
      if (coveredCount == 0) {
         return "ff0000";
      }
      else if (coveredCount == totalCount) {
         return "00ff00";
      }

      double percentage = 100.0 * coveredCount / totalCount;
      int green = (int) (0xFF * percentage / 100 + 0.5);
      int red = 0xFF - green;

      StringBuilder color = new StringBuilder(6);
      appendColorInHexadecimal(color, red);
      appendColorInHexadecimal(color, green);
      color.append("00");

      return color.toString();
   }

   private static void appendColorInHexadecimal(StringBuilder colorInHexa, int rgb)
   {
      String hex = Integer.toHexString(rgb);

      if (hex.length() == 1) {
         colorInHexa.append('0');
      }

      colorInHexa.append(hex);
   }
}
