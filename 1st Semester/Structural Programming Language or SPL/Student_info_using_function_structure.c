#include <stdio.h>
#include <string.h>

struct student {
    char name[100];
    int roll;
    float cgpa;
};

void printinfo(struct student s1);

int main() {
    struct student s1 = {"Limon", 19, 3.99};
    printinfo(s1);

    return 0;
}

void printinfo(struct student s1) {
    printf("Student information: \n");
    printf("Student name = %s\n", s1.name);
    printf("Student roll = %d\n", s1.roll);
    printf("Student cgpa = %f\n", s1.cgpa);
}