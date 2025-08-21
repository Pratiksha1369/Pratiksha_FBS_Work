void main(){
//	7. Calculating total salary based on basic. If basic <=5000 da, ta and hra will be
//10%,20% and 25% respectively otherwise da, ta and hra will be 15%,25% and 30%
//respectively.

	int salary;
	printf("Enter your basic salary: ");
	scanf("%d",&salary);
	
	int da,ta,hra;
	if(salary<=5000){
		da =(salary*10)/100;
		ta = (salary*20)/100;
		hra = (salary*25)/100;
		int total_salary = salary+da+ta+hra;
		printf("Dearness Allowance:%d\n",da);
		printf("Travel Allowance:%d\n",ta);
		printf("House rent Allowance:%d\n",hra);
		printf("Total Salary: %d",total_salary);
	}else{
		da =(salary*15)/100;
		ta = (salary*25)/100;
		hra = (salary*30)/100;
		int total_salary = salary+da+ta+hra;
		printf("Dearness Allowance:%d\n",da);
		printf("Travel Allowance:%d\n",ta);
		printf("House rent Allowance:%d\n",hra);
		printf("Total Salary: %d",total_salary);
		
	}
}