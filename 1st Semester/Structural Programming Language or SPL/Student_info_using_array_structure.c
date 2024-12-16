#include<stdio.h>
#include<string.h>

struct student {
    char name[100];
    int roll;
    float cgpa;
};

int main() {
    struct student CSE[100];
    
    CSE[0].roll = 19;
    CSE[0]. cgpa = 3.99;
    strcpy(CSE[0].name, "Limon");
    
    printf("The name of the CSE[0] student is: %s\n", CSE[0].name);
    printf("The roll of the CSE[0] student is: %d\n", CSE[0].roll);
    printf("The cgpa of the CSE[0] student is: %f\n", CSE[0].cgpa);

    printf("\n");

    CSE[1].roll = 20;
    CSE[1]. cgpa = 3.98;
    strcpy(CSE[1].name, "Hossain");

    printf("The name of the CSE[1] student is: %s\n", CSE[1].name);
    printf("The roll of the CSE[1] student is: %d\n", CSE[1].roll);
    printf("The cgpa of the CSE[1] student is: %f\n", CSE[1].cgpa);
    
    printf("\n");

    CSE[2].roll = 20;
    CSE[2]. cgpa = 3.98;
    strcpy(CSE[2].name, "Shahed");

    printf("The name of the CSE[2] student is: %s\n", CSE[2].name);
    printf("The roll of the cse[2] student is: %d", CSE[2].roll);
    printf("The cgpa of the CSE[2] student is: %f", CSE[2].cgpa);
    
    return 0;
}