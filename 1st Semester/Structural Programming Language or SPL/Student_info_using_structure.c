#include<stdio.h>
#include<string.h>

struct student {
    char name[100];
    int roll;
    float cgpa;
};

int main() {
    //struct student s1;
    //s1.roll = 19;
    //s1. cgpa = 3.99;
    //strcpy(s1.name, "Limon");
    struct student s1 = {"LIMON", 19, 3.99};
    
    printf("The name of the student is: %s\n", s1.name);
    printf("The roll of the student is: %d\n", s1.roll);
    printf("The cgpa of the student is: %f\n", s1.cgpa);
    
    return 0;
}