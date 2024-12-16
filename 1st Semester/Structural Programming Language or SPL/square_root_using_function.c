#include <stdio.h>
#include <math.h>

int main() {
  double number, result;

  printf("Enter a non-negative number: ");
  scanf("%lf", &number);

  // Check for negative input (square root is not defined for negative numbers)
  if (number < 0) {
    printf("Error: Square root is not defined for negative numbers.\n");
    return 1;  // Indicate error
  }

  result = sqrt(number);
  printf("The square root of %.2lf is %.2lf\n", number, result);

  return 0;
}