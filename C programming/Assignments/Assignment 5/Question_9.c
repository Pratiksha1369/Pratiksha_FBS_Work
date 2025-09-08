//9. Print a hollow square pattern 
//Input: n = 4 
//Output: 
//*  *  *  * 
//*        * 
//*        * 
//*        *
//*        *
//*  *  *  *

void main(){
	int n=4;
	for(int i=1;i<=n;i++){
		for(int j=1;j<=n;j++){
			if(i==1 || i==4 || j==1 || j==4)
				printf("* ");
			else
				printf("  ");
		
		}
		printf("\n");
	}
}