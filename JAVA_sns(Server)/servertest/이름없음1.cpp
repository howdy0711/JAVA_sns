#include<stdio.h>
#include<stdlib.h>
int main()
{
	
	char *p;
	p=(char*)malloc(100);
	printf("%d\n");
		
		*p=10;
		p++;
		*p=20;
		
		printf("%d",*p);
		

	free(p);
	
}
