void main(){
//	2. Accept three sides of a triangle from the user and determine whether the triangle is
//equilateral, isosceles, or scalene.
int a,b,c;
printf("Enter values of sides of triangle: ");
scanf("%d",&a);
scanf("%d",&b);
scanf("%d",&c);

if(a==b && b==c && a==c){
	printf("Equilateral Triangle");
}else if(a==b || a==c || b==c){
	printf("Isosceles Triangle");
}else{
	printf("Scalane Triangle");
}

}