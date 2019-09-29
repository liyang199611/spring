-------------------------------------------------------------------------------------------------------------------------------------
k8s 单机安装
-------------------------------------------------------------------------------------------------------------------------------------
参考项目地址
https://github.com/gjmzj/kubeasz/blob/master/docs/quickStart.md
文档中脚本默认均以root用户执行

------------安装 epel 源并更新
---------删除不要的默认安装
---------安装依赖工具

yum install epel-release -y
yum install python-pip libselinux-python wget -y

yum erase firewalld firewalld-filesystem python-firewall -y



yum update -y


--------显示连接信息（所有网卡信息，绿色启用，白色停用）

nmcli conn show
（名称         UUID                                  类型            设备 
static-eth0  a3f6fbd4-0467-4598-9a8f-b4df2690401f  802-3-ethernet  eth0 
eth0         1867295c-d350-49e9-b80b-89115db049bf  802-3-ethernet  --   
[root@k8s1425 ~]# 
）
---------新增一个IP（增加static-eth0网卡，没做）

sudo nmcli con add con-name "static-eth0" ifname eth0 type ethernet ip4 172.17.14.25/16 gw4 172.17.1.254 ipv4.dns 211.161.159.115

-------更改机器名字为k8s1481master

sudo nmcli general hostname k8s1425 

nmcli con down eth0（停用eth0，没做）

---------删除swap

swapoff -a

wget https://github.com/gjmzj/kubeasz/archive/v186-r1.tar.gz 
tar zxvf v186-r1.tar.gz

（方式一：将文件从windows copy 到linux
本机Git base here
输入scp xxx root@172.17.14.25：~/.  (将文件copy到172.17.14.25的home（~）目录下，不更改文件名（.）)
方式二：从172.17.14.21 copy 到 172.17.14.25
scp root@172.17.14.21：~/k8s.184.tar.gz .）

tar zxvf k8s.184.tar.gz

pip install pip --upgrade -i http://mirrors.aliyun.com/pypi/simple/ --trusted-host mirrors.aliyun.com 
pip install --no-cache-dir ansible -i http://mirrors.aliyun.com/pypi/simple/ --trusted-host mirrors.aliyun.com

ssh-keygen -t rsa -b 2048 回车 回车 回车 
ssh-copy-id $IP #$IP为本虚机地址，按照提示输入yes 和root密码

mv kubeasz-186-r1 /etc/ansible 
mv bin/* /etc/ansible/bin

-----配置ansible的hosts文件

cd /etc/ansible

sudo mkdir -p /etc/kubernetes/ssl (没做)
scp root@172.17.14.21:/etc/kubernetes/ssl/ca* /etc/kubernetes/ssl/.（没做）

----复制一个安装模板文件

cp example/hosts.allinone.example hosts


替换hosts文件中的ＩＰ


sed -i 's/192.168.1.1/172.17.14.81/' /etc/ansibe/hosts（没做）
(  vi里替换
vi hosts
:%s/192.168.1.1/172.17.14.25/g  
:wq
)

ansible-playbook 90.setup.yml # 一步安装




5.验证安装

# 如果提示kubectl: command not found，退出重新ssh登陆一下，环境变量生效即可
kubectl version
kubectl get componentstatus # 可以看到scheduler/controller-manager/etcd等组件 Healthy
kubectl cluster-info # 可以看到kubernetes master(apiserver)组件 running
kubectl get node # 可以看到单 node Ready状态
kubectl get pod --all-namespaces # 可以查看所有集群pod状态
kubectl get svc --all-namespaces # 可以查看所有集群服务状态

-------------------------------------------------------------------------------------------------------------------------------------
k8s 集群安装
-------------------------------------------------------------------------------------------------------------------------------------

k8s 集群
172.17.14.21
172.17.14.22
172.17.14.23



# 新增一个IP（增加static-eth0网卡，每台机器）

`sudo nmcli con add con-name "static-eth0" ifname eth0 type ethernet ip4 172.17.14.21/16 gw4 172.17.1.254 ipv4.dns 211.161.159.115`

`sudo nmcli con add con-name "static-eth0" ifname eth0 type ethernet ip4 172.17.14.22/16 gw4 172.17.1.254 ipv4.dns 211.161.159.115`

`sudo nmcli con add con-name "static-eth0" ifname eth0 type ethernet ip4 172.17.14.23/16 gw4 172.17.1.254 ipv4.dns 211.161.159.115`


#启用
nmcli con down eth0

需要用对应修改的ip再次登录
--------显示连接信息（所有网卡信息，绿色启用，白色停用）

nmcli conn show

-------更改机器名字为k8s1481master（每台机器）

sudo nmcli general hostname k8s71 
sudo nmcli general hostname k8s72
sudo nmcli general hostname k8s73
sudo nmcli general hostname k8s74



------------安装 epel 源并更新（所有机器）

yum install epel-release -y
yum install python-pip libselinux-python wget -y
yum erase firewalld firewalld-filesystem python-firewall -y
swapoff -a
yum update -y



---------删除swap（只在主机执行）

swapoff -a

wget https://github.com/gjmzj/kubeasz/archive/v193-r1.tar.gz 



tar zxvf v193-r1.tar.gz



（方式一：将文件从windows copy 到linux
本机Git base here
输入scp xxx root@172.17.14.25：~/.  (将文件copy到172.17.14.25的home（~）目录下，不更改文件名（.）)
方式二：从172.17.14.21 copy 到 172.17.14.25
scp root@172.17.14.21：~/k8s.184.tar.gz .）

tar zxvf k8s.193.tar.gz

pip install pip --upgrade -i https://mirrors.aliyun.com/pypi/simple/
pip install --no-cache-dir ansible -i https://mirrors.aliyun.com/pypi/simple/

-----生成KEY文件
ssh-keygen -t rsa -b 2048 回车 回车 回车 【】【】【】
ssh-copy-id $IP #$IP为本虚机地址，按照提示输入yes 和root密码

mv kubeasz-196-r1 /etc/ansible 

mv -f bin/* /etc/ansible/bin

--------设定主机无密码登录其它node机器 （改名之后）

主机里，进入vi里拷贝主机公钥到对应节点机器
cat ~/.ssh/id_rsa.pub


打开其它节点机器，进入vi 粘贴公钥
vi ~/.ssh/authorized_keys

i 编辑
end 跳到最后一行
esc 退出编辑

：wq
cat ~/.ssh/authorized_keys



-----配置ansible的hosts文件（只在主机执行）

cd /etc/ansible

sudo mkdir -p /etc/kubernetes/ssl (不做)
scp root@172.17.14.21:/etc/kubernetes/ssl/ca* /etc/kubernetes/ssl/.（不做）


----复制一个安装模板文件（只在主机执行）

cp /etc/ansible/example/hosts.s-master.example /etc/ansible/hosts


替换hosts文件中的ＩＰ


sed -i 's/192.168.1.1/172.17.14.81/' /etc/ansibe/hosts（不做）

vi里替换hosts文件的IP
vi hosts
:%s/192.168.1.1/192.9.202.74/g
:%s/192.168.1.2/192.9.202.73/g
:%s/192.168.1.3/192.9.202.72/g  
:wq


---------------------------------------------------------

ansible-playbook 90.setup.yml # 一步安装
（只在主机执行）

-------------------新增node
cd /etc/ansible
vi hosts
修改以下：
# 预留组，后续添加node节点使用
[new-node]
172.17.14.34 NODE_ID=node4 NODE_IP="172.17.14.34"
:wq

ansible-playbook 20.addnode.yml #新增节点


验证安装

# 如果提示kubectl: command not found，退出重新ssh登陆一下，环境变量生效即可
kubectl version
kubectl get componentstatus # 可以看到scheduler/controller-manager/etcd等组件 Healthy
kubectl cluster-info # 可以看到kubernetes master(apiserver)组件 running
kubectl get node # 可以看到单 node Ready状态
kubectl get pod --all-namespaces # 可以查看所有集群pod状态
kubectl get svc --all-namespaces # 可以查看所有集群服务状态

-------------------------------------------------------------------------------------------------------------------------------------
K8S部署云中台
-------------------------------------------------------------------------------------------------------------------------------------


配置文件列表
# 	文件名 	类别 	描述
1 	core.yml 	deploy 	云中台核心模块k8s启动配置
2 	omni.yml 	deploy 	云中台前端组件模块k8s启动配置
3 	omd.yml 	deploy 	云中台主数据模块k8s启动配置
4 	omo.yml 	deploy 	云中台订单模块k8s启动配置
5 	omc.yml 	deploy 	云中台会员模块k8s启动配置
6 	oms.yml 	deploy 	云中台库存模块k8s启动配置
7 	ingress.yml 	ingress 	云中台k8s入口配置
注意查看yml文件中的仓库路径如果有-vpc则表示是内网地址。


准备工作
    一个完整的k8s集群（建议至少3台worker机器）
    拷贝配置文件列表中的文件

---------------拷贝配置文件（主机）

将文件从windows copy 到linux
本机Git base here
输入scp xxx（文件名） root@172.17.14.31：~/.  (将文件copy到172.17.14.25的home（~）目录下，不更改文件名（.）)

scp core.yml root@172.17.14.31:~/.
scp omni.yml root@172.17.14.31:~/.
scp omd.yml root@172.17.14.31:~/.
scp omo.yml root@172.17.14.31:~/.
scp omc.yml root@172.17.14.31:~/.
scp oms.yml root@172.17.14.31:~/.
scp ingress.yml root@172.17.14.31:~/.


--------------------------------------------部署模块

	k8S密钥             kubectl create secret docker-registry aliyun-secret --docker-server=registry.cn-hangzhou.aliyuncs.com --docker-username=docker@efuture --docker-password=fnQ4G1epwY5cgEA --docker-email=yzt@e-future.com.cn
    部署云中台核心模块 kubectl create -f core.yml
    部署云中台前端组件模块 kubectl create -f omni.yml
    部署云中台主数据模块 kubectl create -f omd.yml
    部署云中台订单模块 kubectl create -f omo.yml
    部署云中台会员模块 kubectl create -f omc.yml
    部署云中台库存模块 kubectl create -f oms.yml
	
------------------------------------------------创建服务

kubectl expose deploy omni-ui-res --name=omni-ui-res --port=80 --target-port=8080

kubectl expose deploy amp-ui-business --name=amp-ui-business --port=80 --target-port=8080

kubectl expose deploy amp-auth-service --name=amp-auth-service --port=80 --target-port=8080

kubectl expose deploy amp-auth-webin --name=amp-auth-webin --port=80 --target-port=8080

kubectl expose deploy amp-openapi-service --name=amp-openapi-service --port=80 --target-port=8080

kubectl expose deploy tenant-ui-business --name=tenant-ui-business --port=80 --target-port=8080

kubectl expose deploy tenant-webin --name=tenant-webin --port=80 --target-port=8080

kubectl expose deploy user-ui-business --name=user-ui-business --port=80 --target-port=8080

kubectl expose deploy user-webin --name=user-webin --port=80 --target-port=8080

kubectl expose deploy omd-ui-business --name=omd-ui-business --port=80 --target-port=8080

kubectl expose deploy omd-dict-webin --name=omd-dict-webin --port=80 --target-port=8080

kubectl expose deploy omd-organization-webin --name=omd-organization-webin --port=80 --target-port=8080

kubectl expose deploy omd-goods-webin --name=omd-goods-webin --port=80 --target-port=8080

kubectl expose deploy omd-daemon --name=omd-daemon --port=80 --target-port=8080

kubectl expose deploy omd-query --name=omd-query --port=80 --target-port=8080

kubectl expose deploy omd-tag-webin --name=omd-tag-webin --port=80 --target-port=8080

kubectl expose deploy omc-ui-business --name=omc-ui-business --port=80 --target-port=8080

kubectl expose deploy omc-customer --name=omc-customer --port=80 --target-port=8080

kubectl expose deploy omo-ui-business --name=omo-ui-business --port=80 --target-port=8080

kubectl expose deploy omo-order --name=omo-order --port=80 --target-port=8080

kubectl expose deploy omo-daemon --name=omo-daemon --port=80 --target-port=8080

kubectl expose deploy oms-ui-business --name=oms-ui-business --port=80 --target-port=8080

kubectl expose deploy oms-stock --name=oms-stock --port=80 --target-port=8080

kubectl expose deploy oms-daemon --name=oms-daemon --port=80 --target-port=8080

kubectl expose deploy oms-ui-business --name=oms-ui-business --port=80 --target-port=8080

kubectl expose deploy oms-stock --name=oms-stock --port=80 --target-port=8080

kubectl expose deploy oms-daemon --name=oms-daemon --port=80 --target-port=8080




-----------------------------------------------------暴露服务

通过ingress暴露 kubectl create -f ingress.yml

kubectl get all

其中AVAILABLE 有值才表示成功

------------------------------------------------------安装主要组件

# 安装kubedns
kubectl create -f /etc/ansible/manifests/kubedns
# 安装heapster
kubectl create -f /etc/ansible/manifests/heapster
# 安装dashboard
kubectl create -f /etc/ansible/manifests/dashboard
# 安装traefik ingress-controller
kubectl create -f /etc/ansible/manifests/ingress/traefik-ingress.yaml

------------------------------------------------------ 访问主页
浏览器url：ip:23456/amp-ui-business/portal/index.html#login
账户：bjcsf 密码：123456
如若点击登陆卡死
vi 20-core.xml 
修改mongodb-master服务ip为本机ip

-----------------------------------------------------常用命令

- 新建服务:  
`kubectl create --save-config -f 文件名`
- 更新服务:  
`kubectl apply -f 文件名`
- 查看所有服务:  
`kubectl get pod` 
- 查看日志:  
`kubectl logs 服务名` 
- 进入容器:  
`kubectl exec -it 服务名 /bin/bash or /bin/sh` 
- 查看所有svc:  
`kb get svc`  
- 删除指定 svc:   
`kb delete svc  svc名称`
- 查看所有deploy
kubectl get deploy
- 删除指定 deploy
kubectl delete deploy deploy名称
- 查看ingress
kubectl get ingress 
- 删除ingress 
kubectl delete ingress ingress名称

如有错误欢迎修改补充!