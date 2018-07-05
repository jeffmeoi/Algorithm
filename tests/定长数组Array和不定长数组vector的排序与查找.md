# 定长数组Array和不定长数组vector的排序与查找

## 分析
详见Cpp Standard Library.
```cpp

sort(首地址， 尾地址);  //排序构造1

sort(首地址， 尾地址， 比较函数);  //排序构造2

lower_bound(首地址， 尾地址，数值大小);  //查找

#include<vector>

vector<typename> name;   //vector声明

name.push_back(新增元素);  //vector末尾增添元素

name.pop_back();  //vector末尾删除元素

name.begin();  //vector首元素地址

name.end();  //vector末元素地址

name.size();  //vector尺寸

name.resize(新尺寸);  //vector定义新尺寸

name.clear();   //vector清空

```


## 源代码

```cpp

#include<cstdio>
#include<algorithm>
#include<vector>
#include<iostream>

#define maxn 10

using namespace std;

bool compare1(int a,int b){
	
  return a > b;									//a > b 为降序， a < b 为升序 
}

bool compare2(int a, int b){
	
  return a > b;									//a > b 为降序， a < b 为升序 
}

int main(int argc, char* argv[]){
	
	//array排序 
	int a[maxn] = {1 , 5, 3, 9, 4, 5, 6, 7, 8, 4};
	sort(a, a + maxn);								//默认升序 
	sort(a, a + maxn, compare1);					//重写比较函数，降序 
	for(int i = 0; i < maxn; i++)
		printf("%5d", a[i]);
	cout<<endl;
	//array查找大于等于第三个参数的第一个数的位置 
	int p = lower_bound(a, a + maxn, 5) - a; 			//lower_bound()获取的是指针 
	cout<<p<<endl;			//a[p] == 5
	
	
	//vector排序 
	vector<char> b;
	b.push_back('e');						//vector末尾插入元素 
	b.push_back('a');
	b.push_back('g');
	b.push_back('c');
	b.push_back('f');
	b.push_back('l');
	b.push_back('p');
	b.push_back('h');
	b.push_back('i');
	b.push_back('o');
	
	sort(b.begin(), b.end());						//默认升序 
	sort(b.begin(), b.end(), compare2);					//重写比较函数，降序
	for(int i = 0; i < maxn; i++)
		printf("%5c", b[i]);
	cout<<endl;
	////vector查找大于等于第三个参数的第一个数的位置 
	p = lower_bound(b.begin(), b.end(), 'f') - b.begin(); 		//lower_bound()获取的是指针 
	cout<<p<<endl;			//b[p] == 'f'
	b.resize(100);							//重新定义vector的大小
	b.pop_back();							//vector末尾删除元素 
	b.size();							//获取vector的长度 
	b.clear();							//清空vector的元素 
	
	
	return 0;
}

```
