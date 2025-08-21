//Write a C program to swap two numbers using a temporary third variable.

void main() {
	int a =10,b = 20;
	int temp;
	temp = a;
	a = b;
	b = temp;
	
	printf("a = %d\n,b = %d\n",a,b);
}
