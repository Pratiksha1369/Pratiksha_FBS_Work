//Write a C program to swap two numbers using a temporary third variable.

void main() {
	int a =10,b = 20;
	printf("Before swapping\n");
	printf("a = %d \nb = %d\n",a,b);
	int temp;
	temp = a;
	a = b;
	b = temp;
	printf("After swapping\n");
	printf("a = %d\nb = %d\n",a,b);
}
