# 우분투 리눅스
## 실습환경
### VMware
- [다운로드](https://www.vmware.com/kr/products/workstation-pro/workstation-pro-evaluation.html)
- Player
    1. 가상머신 만들기
        - Home > Create a New Virtual Machine
            1. 가상 머신만 만들고 설치는 나중에 (I will install the operating system later)
            2. 운영체제 선택 (Linux , Ubuntu 64-bit)
            3. 가상머신 이름(Server), 가상머신 위치(C:\Ubuntu20.04\Server)
            4. 가상머신 용량 (80Gb), single file
            5. 요약 및 커스터마이징
        - Edit Virtual Machine Setting 에서 하드웨어 등 설정 편집 가능
- Pro (30일 제한, 부가기능만 사용)
    1. Virtual Network Editor 기능
        - 윈도우에서 네트워크 확인
            - `ipcofnig`
            - VMWare Networ Adapater VMnet8
            - [Edit] > [Virtual Network Editor]
            - VMnet8 (주의! VMnet1이 아님!)
            - Change Setting
            - Subnet IP : 192.168.111.0
    2. 스냅숏 기능
        - 기존 가상머신 열기 (File - Open - 폴더탐색 - *.vmx)
        - 메뉴 -> VM -> Snapshot -> Snapshot Manager
        - Take a Snapshot
        * (Player가 실행 중일때는 사용할 수 없음, 모두 종료)
        - 스냅숏 시점으로 원상복구(초기화)
            - VM - Snapshot - snapshot Manager
            - (스냅샷선택) - Go to
![실습환경](images/servers.png)
### 1. Server (Ubuntu 20.04 DeskTop)
- [우분투 데스크톱 다운로드](http://old-releases.ubuntu.com/releases/20.04.0/ubuntu-20.04-desktop-amd64.iso)
```sh
# 루트(슈퍼유저) 권한 얻기
sudo su - root
# 패스워드 설정 (password 2회)
passwd
# apt 소스 백업 및 가져오기
mv sources.list sources.list.bak
wget http://dw.hanbit.co.kr/ubuntu/20.04/sources.list
# 패키지 관리자 업데이트
apt update
# 네트워크 패키지 설치
apt -y install net-tools
# 방화벽 작동
ufw enable
```
### 2. Server(B) (Ubuntu 20.04 Server)
- [우분투 서버 다운로드](http://old-releases.ubuntu.com/releases/20.04.0/ubuntu-20.04-live-server-amd64.iso)
### 3. Client (Kubuntu 20.04)
- [쿠분투 다운로드](http://cdimage.ubuntu.com/kubuntu/releases/20.04/release/kubuntu-20.04.6-desktop-amd64.iso)
### 4. WinClient (Win 10 평가판)
- [평가판 다운로드 링크(한국어 32bit)](https://www.microsoft.com/ko-kr/evalcenter/download-windows-10-enterprise)
## 네트워크 설정
![network](images/network_2.png)
- 우분투 데스크톱 서버
    - 우측상단 메뉴 설정
    - 네트워크 -> 유선 -> 톱니바퀴
    - DHCP (아이피 동적할당) : 수동
    - 주소 192.168.111.100
    - 넷마스크 255.255.255.0
    - 게이트웨이 192.168.111.2
    - 네임서버(DNS) 192.168.111.2
- `ip addr`로 확인
- 우분투 서버 (서버 B)
```
sudo nano /etc/netplan/00-installer-config.yaml
```
```yaml
network:
  ethernets:
    ens32:
     dhcp4: no
     addresses: [192.168.111.200/24]
     gateway4: 192.168.111.2
     nameservers:
       addresses: [192.168.111.2]
```
## VMware 장애 해결
- VMware Player unrecoverable error: (mks)
- VMware 에러 해결
- cmd 관리자 권한 열기
```
# 파일 편집기 열기
code "C:\ProgramData\VMware\VMware Workstation\config.ini"
# 마지막 줄에 추가
mks.enableDX12Renderer=FALSE
```