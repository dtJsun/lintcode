#include <iostream>
using namespace std;

/*传二维数组*/

//第1种方式：传数组,第二维必须标明
/*void display(int arr[][4])*/
void display1(int arr[][4],const int irows)
{
    for (int i=0;i<irows;++i)
    {
        for(int j=0;j<4;++j)
        {
            cout<<arr[i][j]<<" ";     //可以采用parr[i][j]
        }
        cout<<endl;
    }
    cout<<endl;
}

//第2种方式：一重指针，传数组指针,第二维必须标明
/*void display(int (*parr)[4])*/
void display2(int (*parr)[4],const int irows)
{
    for (int i=0;i<irows;++i)
    {
        for(int j=0;j<4;++j)
        {
            cout<<parr[i][j]<<" ";    //可以采用parr[i][j]
        }
        cout<<endl;
    }
    cout<<endl;
}
//注意：parr[i]等价于*(parr+i)，一维数组和二维数组都适用

//第3种方式：传指针,不管是几维数组都把他看成是指针
/*void display3(int *arr)*/
void display3(int *arr,const int irows,const int icols)
{
    for(int i=0;i<irows;++i)
    {
        for(int j=0;j<icols;++j)
        {
            cout<<*(arr+i*icols+j)<<" ";   //注意:(arr+i*icols+j),不是(arr+i*irows+j)
        }
        cout<<endl;
    }
    cout<<endl;
}

/***************************************************************************/
/*
//第2种方式：一重指针，传数组指针void display(int (*parr)[4])
//缺陷：需要指出第二维大小
typedef int parr[4];
void display(parr *p)
{
    int *q=*p;        //q指向arr的首元素
    cout<<*q<<endl;   //输出0
}

typedef int (*parr1)[4];
void display1(parr1 p)
{
    cout<<(*p)[1]<<endl;  //输出1
    cout<<*p[1]<<endl;    //输出4,[]运算符优先级高
}
//第3种方式：
void display2(int **p)
{
    cout<<*p<<endl;           //输出0
    cout<<*((int*)p+1+1)<<endl; //输出2
}
*/

int main()
{
    int arr[][4]={0,1,2,3,4,5,6,7,8,9,10,11};
    int irows=3;
    int icols=4;
    display1(arr,irows);
    display2(arr,irows);

    //注意(int*)强制转换.个人理解：相当于将a拉成了一维数组处理。
    display3((int*)arr,irows,icols);
    return 0;
}