void main(){
//	convert time hh,mm,sec into total sec
int hour,min,sec;
printf("Enter hour: ");
scanf("%d",&hour);
printf("Enter min: ");
scanf("%d",&min);
printf("Enter sec: ");
scanf("%d",&sec);
//5:30:00
int hour_sec = hour*60*60;
printf("%d sec\n",hour_sec);
int min_sec=min*60;
printf("%d sec\n",min_sec);

//printf("The time you enter:Hour:min:sec",hour,min,sec);
int total_sec = hour_sec+min_sec+sec;
printf("Total seconds:%d",total_sec);





}