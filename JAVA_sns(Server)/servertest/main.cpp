#include <stdio.h>

int main() {
	int a=10;
	int *p,**pp;
	p=&a;
	pp=&p;
	
	printf("%d\n",&p);
	printf("%d",pp);
	
	
	return 0;
}
