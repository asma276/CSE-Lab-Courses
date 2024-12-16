#include <stdio.h>

int main() {
    int pin, choice, amount;
    float balance = 1000.00; // Initial balance (replace with appropriate data storage)

    printf("Enter your PIN: ");
    scanf("%d", &pin);

    // Simulate PIN verification (replace with actual validation)
    if (pin == 1234) {
        printf("\nWelcome!\n");

        printf("1. Check Balance\n");
        printf("2. Withdraw Cash\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        if (choice == 1) {
            printf("Your balance: %.2f\n", balance);
        } else if (choice == 2) {
            printf("Enter amount to withdraw: ");
            scanf("%d", &amount);

            if (amount <= balance) {
                balance -= amount;
                printf("Withdrawal successful. Please collect your cash.\n");
                printf("Remaining balance: %.2f\n", balance);
            } else {
                printf("Insufficient funds.\n");
            }
        } else {
            printf("Invalid choice.\n");
        }
    } else {
        printf("Incorrect PIN.\n");
    }

    return 0;
}
