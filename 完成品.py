
"""
with open("C:\\Users\\chi\\Desktop\\bank.txt") as f:
    for line in f:
       print(line)
print(line)
"""
"""
def readfile():
    with open("C:\\Users\\chi\\Desktop\\bank.txt") as f:
        for line in f:
           print(line)

    return line
"""
"""
class operate:
    def readfile(self):
        flist=[]
        with open("C:\\Users\\chi\\Desktop\\bank.txt") as f:
            for line in f:
               line=line.strip('\n')
               flist.append(line)
               print(line)

        return flist
strf=[]
strf=operate()
print(strf.readfile())
"""
"""
class operate:
    def readfile(self):
        flist=[]
        #flist.append([])
        with open("C:\\Users\\chi\\Desktop\\bank.txt") as f:
            num=0
            for line in f:
                line=line.strip('\n')
                flist.append([])
              #  a=line.count(',')
             #   print("a",a)
                for a in range(line.count(',')+1):
                    flist[num].append(line.split(",")[a])
                    
                print(line)
                print(num)
                num+=1
        return flist
strf=[]
strf.append([])
strf=operate()
print(strf.readfile())
"""
"""
class operate:
    print("***")
    def readfile(self):
        flist=[]
        #flist.append([])
        with open("C:\\Users\\chi\\Desktop\\bank.txt") as f:
            num=0
            for line in f:
                line=line.strip('\n')
                flist.append([])
              #  a=line.count(',')
             #   print("a",a)
                for a in range(line.count(',')+1):
                    flist[num].append(line.split(",")[a])
                    
                print(line)
                print(num)
                num+=1
        return flist
class Confirmn(operate):
    def confirmn(self, inputName, inputPasswd):
        #print(inputName)
        listC=[]
        listC.append([])
        listC=operate.readfile(self)
        #print('list:',listC)
        #print(listC[0][0])
        for idx,one in enumerate(listC):
            if listC[idx][0] ==inputName:
                print(listC[idx][0])
                if listC[idx][1]==inputPasswd:
                    print(listC[idx][1])
                    
                    
        return print("無此帳號")

#class select:
 #   def 
    


inputN=input("請輸入帳戶名稱:")
inputP=input("請輸入帳戶密碼:")
c=Confirmn()
c.confirmn(inputN,inputP)
#strf=[]
#strf.append([])
#strf=operate()
#print(strf.readfile())
"""

"""
class operate:
    print("***")
    def readfile(self):
        flist=[]
        #flist.append([])
        with open("C:\\Users\\chi\\Desktop\\bank.txt","r") as f:
            num=0
            for line in f:
                line=line.strip('\n')
                flist.append([])
              #  a=line.count(',')
             #   print("a",a)
                for x in range(line.count(',')+1):
                    flist[num].append(line.split(",")[x])
                    
                print(line)
                print(num)
                num+=1
        return flist
            
class select(operate):
    def option(self, line):
        print(line)
        print("請選擇服務項目\n","(1)存款\n(2)提款\n(3)密碼更改\n(4)建立帳戶\n(5)離開")
        inputS=input()
        if inputS=="1":
            print("1")
            a=0
            self.deposit(a)
        elif inputS=="2":
            print("2")
        elif inputS=="3":
            print("3")
        elif inputS=="4":
            print("4")
        else:
             exit()
    def deposit(self, amount):
        amount=input("輸入金額") 
        print(amount)
       # operate.writefile(self)
        print("456")
        
        
        
class Confirmn(select):
    def confirmn(self, inputName, inputPasswd):
        #print(inputName)
        listC=[]
        listC.append([])
        listC=operate.readfile(self)
        #print('list:',listC)
        #print(listC[0][0])
        for idx,one in enumerate(listC):
            if listC[idx][0] ==inputName:
                print(listC[idx][0])
                if listC[idx][1]==inputPasswd:
                    print(listC[idx][1])
                    b=listC[idx][2]
                    print(b)
                    return select.option(self, idx)
        return print("無此帳號")


    


inputN=input("請輸入帳戶名稱:")
inputP=input("請輸入帳戶密碼:")
c=Confirmn()
c.confirmn(inputN,inputP)
#strf=[]
#strf.append([])
#strf=operate()
#print(strf.readfile())
"""


class operate:                                                 #讀檔 寫檔
    print("***")
    def readfile(self):
        flist=[]
        with open("C:\\Users\\chi\\Desktop\\bank.txt","r") as f:
            num=0
            for line in f:
                line=line.strip('\n')
                flist.append([])
              #  a=line.count(',')
             #   print("a",a)
                for x in range(line.count(',')+1):
                    flist[num].append(line.split(",")[x])
                    
               # print(line)
                #print(num)
                num+=1
        return flist
    def writefile(self,id_x,a,ID,pw,B):                            #寫檔：存款、提款
        with open("C:\\Users\\chi\\Desktop\\bank.txt","r+") as f:

            if int(B) < -a:                         
                print('餘額不足，請重新選擇')
                return select.option(self,id_x,ID,pw,B)
            fileaString = f.read() 
            idFilter = B                    
            B=a+int(B)
            idPosition = fileaString.find(idFilter) 
            f.seek(idPosition+id_x+len(idFilter),0)
            pos = f.tell()-len(idFilter)            # 記住目前的位置
            rest_of_file = f.read()                 # 把剩下的讀進來
            f.seek(pos)                             # 回到要插入的位置
            f.truncate()                            # 先把後面的刪掉
            f.write(str(B))
            f.write(rest_of_file)
            
            
        return str(B)
            #filea.write('\n')
    def writefile2(self,id_x,pw,passwd_a):                  #密碼更改
        with open("C:\\Users\\chi\\Desktop\\bank.txt","r+") as f:
            fileaString = f.read()
            idFilter = pw
            idPosition = fileaString.find(idFilter) 
            f.seek(idPosition+id_x,0)
            f.write(passwd_a)
        return passwd_a
    def writeaccount(name,password,balance):#寫入檔案，增加項目
        f = open("C:\\Users\\chi\\Desktop\\bank.txt","a")
        f.write("\n"+name+","+password+","+balance)
        f.close()
                
    
class select(operate):
    def option(self, idx,ID,pw,balance):#功能選擇
        print("請選擇服務項目\n","(1)存款\n(2)提款\n(3)密碼更改\n(4)建立帳戶\n(5)離開")
        inputS=input()
        if inputS=="1":
            print("1")
            a=0
            self.deposit(a,idx,ID,pw,balance)
        elif inputS=="2":
            print("2")
            a=0
            self.withdraw(a,idx,ID,pw,balance)            
        elif inputS=="3":
            a=0
            print("3")
            self.cpass(a,idx,ID,pw,balance)
        elif inputS=="4":
            print("4")
            self.app()
        else:
             exit()
    def deposit(self, amount, idx, ID,pw,Balance):    #存款
        amount=input("輸入金額") 
        print(amount)
        Balance=operate.writefile(self, idx, int(amount), ID,pw,Balance)
        select.option(self,idx,ID,pw,Balance)
    def withdraw(self, amount, idx, ID,pw,Balance):#提款
        amount=input("輸入提款金額") 
        print(amount)
        Balance=operate.writefile(self, idx, int(amount)*-1, ID,pw,Balance)
        select.option(self,idx,ID,pw,Balance)
    def cpass(self,a,idx,ID,pw,balance):#更換密碼
        passwd_a=input("請輸入新密碼")
        passwd_b=input("請再輸入新密碼")
        if passwd_a==passwd_b:
            
            pw=operate.writefile2(self,idx,pw,passwd_a)
            print(pw)
            print("密碼已更改")
        else:
            print("輸入錯誤，請重新執行新執行")
            
        select.option(self,idx,ID,pw,balance)

    def app(self):#建立帳戶
        name=input("請輸入建立帳戶名稱:")
        password=input("請輸入密碼:")
        balance=input("請輸入存款金額:")
        account=operate.writeaccount(name,password,balance)
        Confirmn.confirmn(self)

       
class Confirmn(select):
    def confirmn(self):   #確認帳戶 
        inputName=input("請輸入帳戶名稱:")
        inputPasswd=input("請輸入帳戶密碼:")
        listC=[]
        listC.append([])
        listC=operate.readfile(self)                
        for idx,one in enumerate(listC):
            if listC[idx][0] ==inputName:         #帳號
                print(listC[idx][0])
                if listC[idx][1]==inputPasswd:
                    print(listC[idx][1])
                    id=listC[idx][0]
                    pw=listC[idx][1]
                    b=listC[idx][2]
                    print(b)
                    return select.option(self,idx,id,pw,b)
        return print("無此帳號")


    


#inputN=input("請輸入帳戶名稱:")
#inputP=input("請輸入帳戶密碼:")
c=Confirmn()
c.confirmn()
#strf=[]
#strf.append([])
#strf=operate()
#print(strf.readfile())
