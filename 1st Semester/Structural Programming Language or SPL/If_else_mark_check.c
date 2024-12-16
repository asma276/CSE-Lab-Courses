#include <stdio.h>

int main() {
    int marks;

    printf("Enter student's marks (0-100): ");
    scanf("%d", &marks);

    if (marks >= 90) {
        printf("Excellent!\n");
    } else if (marks >= 80) {
        printf("Very Good.\n");
    } else if (marks >= 70) {
        printf("Good.\n");
    } else if (marks >= 60) {
        printf("Average.\n");
    } else {
        printf("Fail.\n");
    }

    return 0;
}
