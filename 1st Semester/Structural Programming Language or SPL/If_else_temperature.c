#include<stdio.h>
int main() {
    float temperauture;
    printf("Enter temperature in °C= ");
    scanf("%f", &temperauture);

    if (temperauture < 0) {
        printf("Cold");
    }
    else if(temperauture <= 20) {
        printf("Moderate");
    }
    else { printf("Hot"); 
    }
    return 0;
}
