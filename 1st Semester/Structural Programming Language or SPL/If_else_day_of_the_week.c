#include <stdio.h>

int main() {
    int day_num;

    printf("Enter a number (1-7): ");
    scanf("%d", &day_num);

    if (day_num == 1) {
        printf("Monday\n");
    } else if (day_num == 2) {
        printf("Tuesday\n");
    } else if (day_num == 3) {
        printf("Wednesday\n");
    } else if (day_num == 4) {
        printf("Thursday\n");
    } else if (day_num == 5) {
        printf("Friday\n");
    } else if (day_num == 6) {
        printf("Saturday\n");
    } else if (day_num == 7) {
        printf("Sunday\n");
    } else {
        printf("Invalid input (1-7 only).\n");
    }

    return 0;
}
