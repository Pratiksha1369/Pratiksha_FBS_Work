void main(){
	int n=5;
//	int space=0,star=n;
//	for(int i=1;i<=n;i++){
//		for(int s=1;s<=space;s++){
//			printf("  ",space);
//		}
//		for(int s1=1;s1<=star;s1++){
//			printf("* ");
//		}
//		space++;
//		star-=2;
//		printf("\n");
//	}


	for(int i=n-1;i>=1;i--){
		for(int space=1;space<=n-i;space++){
			printf(" ");
		}
		for(int j=1;j<=i;j++){
			printf("* ");
		}
		printf("\n");
	}

}
