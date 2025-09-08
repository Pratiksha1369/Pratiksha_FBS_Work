//pyramid

void main(){
	int num=5;
//	int space=n,star=1;
//	for(int i=1;i<=n;i++){
//		for(int s=1;s<=space;s++){
//			printf("  ",space);
//		}
//		for(int s1=1;s1<=star;s1++){
//			printf("* ");
//		}
//		space--;
//		star+=2;
//		printf("\n");

for(int i=1;i<=num;i++){
	for(int space=1;space<=num-i;space++){
		printf(" ");
	}
	for(int j=1;j<=i;j++){
		printf("* ");
	}
	printf("\n");
    }
}


