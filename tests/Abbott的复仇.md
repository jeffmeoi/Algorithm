Abbott的复仇

题目

https://vjudge.net/problem/UVA-816

样例输入1:

    SAMPLE
    3 1 N 3 3
    1 1 WL NR *
    1 2 WLF NR ER *
    1 3 NL ER *
    2 1 SL WR NF *
    2 2 SL WF ELF *
    2 3 SFR EL *
    0
    NOSOLUTION
    3 1 N 3 2
    1 1 WL NR *
    1 2 NL ER *
    2 1 SL WR NFR *
    2 2 SR EL *
    0
    END



样例输出1:

    SAMPLE
    (3,1) (2,1) (1,1) (1,2) (2,2) (2,3) (1,3) (1,2) (1,1) (2,1)
    (2,2) (1,2) (1,3) (2,3) (3,3)
    NOSOLUTION
    No Solution Possible
    





样例输入2：

    SAMPLE
    3 1 N 3 3
    1 1 WL NR *
    1 2 WLF NR ER *
    1 3 NL ER *
    2 1 SL WR NF *
    2 2 SL WF ELF *
    2 3 SFR EL *
    0
    NOSOLUTION
    3 1 N 3 2
    1 1 WL NR *
    1 2 NL ER *
    2 1 SL WR NFR *
    2 2 SR EL *
    0
    MyMaze1
    3 1 N 1 1
    0
    MyMaze2
    3 1 N 3 1
    0
    MyMaze3
    3 1 N 2 1
    0
    MyMaze4
    2 2 W 3 2
    1 1 NR *
    1 2 ER *
    2 1 WR *
    2 2 SF *
    0
    MyMaze5
    2 2 N 2 3
    1 1 WL *
    1 2 NL *
    2 1 SF *
    2 2 NR *
    3 1 SL *
    3 2 EL *
    0
    Circle
    2 1 N 2 1
    1 1 NR *
    1 2 ER *
    2 2 SF *
    3 1 WR *
    3 2 SR *
    0
    RobertAbbottAtlanta
    4 2 N 4 3
    1 1 NR WL *
    1 2 NLR WF EFR *
    1 3 EFR WFR NL *
    1 4 ER NL *
    2 1 SFL WL NFR *
    2 2 EL SFLR WFRL NFL *
    2 3 EFLR SF NF WFRL *
    2 4 SR ELR NF *
    3 1 WR SL *
    3 2 EFL SLR WR NF *
    3 3 EFL SLR WL *
    3 4 EL SR *
    0
    END
    

样例输出2:

    SAMPLE
      (3,1) (2,1) (1,1) (1,2) (2,2) (2,3) (1,3) (1,2) (1,1) (2,1)
      (2,2) (1,2) (1,3) (2,3) (3,3)
    NOSOLUTION
      No Solution Possible
    MyMaze1
      No Solution Possible
    MyMaze2
      No Solution Possible
    MyMaze3
      (3,1) (2,1)
    MyMaze4
      (2,2) (2,1) (1,1) (1,2) (2,2) (3,2)
    MyMaze5
      (2,2) (1,2) (1,1) (2,1) (3,1) (3,2) (2,2) (2,3)
    Circle
      (2,1) (1,1) (1,2) (2,2) (3,2) (3,1) (2,1)
    RobertAbbottAtlanta
      (4,2) (3,2) (2,2) (1,2) (1,3) (1,4) (2,4) (2,3) (2,2) (3,2)
      (3,1) (2,1) (1,1) (1,2) (2,2) (2,3) (2,4) (3,4) (3,3) (4,3)
    

题意

有一个最多包含9*9个交叉点的迷宫。输入起点、离开起点时的朝向和终点，求一条最短路（多解时任意输出一个即可）

这个迷宫的特殊之处在于：进入一个交叉点的方向（用NEWS这四个字母分别表示北东西南，即上下左右）不同，允许出去的方向也不同。例如，12 WLF NR ER表示交叉点（1,2）（上数第一行，左数第二列）有3个路标（字符“”只是结束标志），如果进入交叉点时的朝向为W（即朝左），则可以左转（L）或者直行（F）；如果进入时朝向为N或者E则只能右转（R）.

---

分析

这是一道令人难过的题目, 花了我整整一天的时间, 还让我下一天浑浑噩噩, 丝毫不想打题. 不过怕忘记思路还是来写一波题解.

这道题的思路其实也很清晰, 只不过比较长容易写崩.

首先, 这道题里我用的是BFS(广度优先搜索), 实现的思路即用队列, 不断地取出节点, 又不断地加入子节点.这道题用BFS而不用DFS的原因在于, 用DFS必须把所有的情况遍历一遍才能确定最小值, 而BFS不需要, 只要是第一个找到了终点, 就说明是d是最小值了. 

程序分了几个模块, 一个是read, 一个是print, 一个是walk(转向及向前走一步), 一个是solve(BFS实现的主体). 

转向用数组来实现, 把0/1/2/3当做一个环, 超出范围取模后再+/-4回到范围.

solve用队列实现.

print可以用vector也可以尝试用stack(之前TLE我以为是stack的问题没想到是死循环所以我改掉了)来实现.

源代码

    //BFS
    #include<cstdio>
    #include<cstring>
    #include<queue>
    #include<vector>
    
    using namespace std;
    const int maxn = 10;
    
    struct Node{	//Node为在某个node时的位置及方向.x,y表示的是以左上角为原点的坐标系中的坐标.
    	int y, x, dir;
    	Node(int y = 0, int x = 0, int dir = 0):y(y), x(x), dir(dir) {};
    };
    
    int ey, ex;		//e表示end, 即终点
    int oy, ox, ty, tx, dir;   //o表示one, 表示出发点, t表示two, 表示第一个点, dir表示开始的朝向
    int d[maxn][maxn][4];		//d表示与出发点后第一个点的距离
    int has_edge[maxn][maxn][4][3];		//has_edge[a][b][c][d]表示在(b,a)点,朝向c时是否可以按照d的走法走.
    Node p[maxn][maxn][4];		//p[a][b][c]表示走到(b,a)并朝向为c时的上一步在哪.
    
    const char* dirs = "NESW";		//dirs与dy和dx一一对应, 且为顺时针/逆时针, 本处采用顺时针.
    const char* turns = "FLR";		//三种走法.F为直行,L为左转,R为右转.
    
    const int dy[] = {-1, 0, 1, 0};		//NESW
    const int dx[] = {0, 1, 0, -1};		//NESW
    
    int dirId(char c){	return strchr(dirs, c) - dirs;	}	//函数取c字符的所在的地址,－dirs表示第几个.
    int turnId(char c){	return strchr(turns, c) - turns;}	//函数取c字符的所在的地址,－dirs表示第几个.
    
    Node walk(const Node& u, int turn){		//按照turn的走法向前走一步的node情况
    	int dir = u.dir;
    	if(turn == 1)	dir = (dir + 3) % 4;	//逆时针, 相当于(dir -1 + 4)% 4
    	if(turn == 2)	dir = (dir + 1) % 4;	//顺时针,
    	return Node(u.y + dy[dir], u.x + dx[dir], dir);		//走向下一步
    }
    
    int print(Node node){		//打印(标题,换行,空两格,,打印十个(空格隔开),再换行,空两格...)
    	vector<Node> nodes;
     	while(true){			//将上一个节点不断地加入数组中
     		nodes.push_back(node);
     		if(d[node.y][node.x][node.dir] == 0)	//这里要注意不要写错, 在没有搞到sample2之前, 我的之前的写法有一种情况会出现死循环自己还没有发现,TLE了好几个小时.注意循环体内是先加入节点再判断是否退出再指向上一步的顺序.
     			break;
     		node = p[node.y][node.x][node.dir];
    	 }
    	nodes.push_back(Node(oy, ox));
    	int j = 0;
    	for(int i = nodes.size() -1; i >= 0; i--){
    		if(j % 10 == 0)
    			printf(" ");
    		printf(" (%d,%d)", nodes[i].y, nodes[i].x);
    		if(++j % 10 == 0)
    			printf("\n");
    	}
    	if(j % 10 != 0)
    		printf("\n");
    } 
    
    int solve(){
    	queue<Node> q;
    	q.push(Node(ty, tx, dir));		//将起始点后第一个点加入q中, 并将该点的d INIT为0
    	d[ty][tx][dir] = 0;
    	while(!q.empty()){				//队列非空即循环.
    		Node u = q.front();
    		q.pop();
    		if(u.y == ey && u.x == ex){		//到达终点即输出
    			print(u);
    			return 1;
    		}
    		for(int i = 0; i< 3; i++){		//三种走法
    			Node v = walk(u, i);		//该走法的下一格的 node
    			if(has_edge[u.y][u.x][u.dir][i] && v.y >= 1 && v.y <=9 && v.x >= 1 && v.x <=9 && d[v.y][v.x][v.dir] < 0  ){			//如果该走法可走, 并且下一格在合理范围内, 并且这个位置的这种方向还没走过.
    				q.push(v);					//加入队列
    				p[v.y][v.x][v.dir] = u;		 //记录上一步
    				d[v.y][v.x][v.dir] = d[u.y][u.x][u.dir] + 1;	//位置+1.
    			}
    		}
    	}
    	printf("  No Solution Possible\n");	//两空格 + No....
    	return 0;
    }
    
    int read(){
    	
    	memset(has_edge, 0, sizeof(has_edge));
    	memset(d, -1, sizeof(d));
    	memset(p, 0, sizeof(p));
    	char name[99], c[99];
    	if(scanf("%s%d%d%s%d%d", name, &oy, &ox, &c, &ey, &ex) != 6)
    		return false;
    	printf("%s\n", name);
    	dir = dirId(c[0]);
    	ty = oy + dy[dir];
    	tx = ox + dx[dir];
    	int my, mx;
    	char expr[10];
    	while(scanf("%d", &my) == 1 && my != 0){
    		scanf("%d", &mx);
    		while(scanf("%s", expr) == 1 && expr[0] != '*'){
    			int len = strlen(expr);
    			for(int i = 1; i < len; i++){
    				has_edge[my][mx][dirId(expr[0])][turnId(expr[i])] = 1;
    			}	
    		}
    	}
    	return true;
    }
    
    int main(int argc, char* argv[]){
    	
    	//freopen("UVa816.in", "r", stdin);
    	while(read()){
    		solve();
    	}
    	
    	return 0;
    } 
    
