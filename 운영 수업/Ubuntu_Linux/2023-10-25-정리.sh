# 링크 연습 (ln)
cd
pwd
ls
ls -l
cd
cd ~
mkdir linktest
cd linktest/
ls
nano basefile       # 원본파일 만들기
ls
ls -l
ln basefile hardlink    # 하드링크 생성
ls -l
cat basefile 
cat hardlink 
ln -s basefile softlink # 소프트링크 생성
ls -l
cat softlink
ls -il
ls
ls -l
mv basefile ../             # 원본 파일 이동 후 확인
pwd
ls -l /root
ls -l
cat softlink
cat hardlink 
ls -il
mv ../basefile .            # 원본 파일 재위치
ls
ls -il
cat softlink

# 패키지 관리자 dpkg
dpkg -l zip                 # dpkg 패키지 관리자 설치 확인
dpkg -L zip
cd
ls
cd 다운로드/
ls
dpkg -l axel
dpkg --info axel_2.17.5-1ubuntu1_amd64.deb  # 패키지파일 정보확인
dpkg -i axel_2.17.5-1ubuntu1_amd64.deb      # 패키지파일 설치하기
axel --help
man axel
axel
axel https://cdn.kernel.org/pub/linux/kernel/v5.x/linux-5.10.198.tar.xz # 실행 다운로드
ls -l
dpkg -l axel
dpkg -r axel        # 패키지 삭제
axel
ls
ls -l
dpkg -l galculator
dpkg -i galculator_2.1.4-1build1_amd64.deb   # 패키지 설치(의존성 문제 발생)
apt
apt-get
dpkg -i galculator
dpkg -l galculator
dpkg -r galculator  # 패키지 삭제
dpkg -l galculator

# 패키지 관리자 apt
apt-cache show galculator       # 패키지 정보 확인
apt-cache depends galculator    # 의존성 정보 확인
apt install galculator          # 패키지 설치 (의존성문제해결)
galculator 
cd /etc/apt
ls
gedit sources.list              # 패키지 목록 확인
less sources.list
nano sources.list
apt update
apt install galculator
apt remove galculator
apt autoremove
apt purge galculator
apt install galculator
nano sources.list

gedit sources.list
apt install galculator
apt update
gedit sources.list
apt update
gedit sources.list
apt update
gedit sources.list
apt update
apt install galculator
galculator 
nano sources.list
apt upgrade
apt update
apt upgrade

# 압축 
cd
mkdir zip-ex        # 압축 테스트용 폴더 만들기
cd zip-ex/
nano test1.txt
ls -l
xz test1.txt        # xz 압축
ls -l
xz -d test1.txt.xz  # xz 압축풀기
ls -l
xz -k test1.txt     # xz 파일 유지하며 압축
ls -l
bzip2 test1.txt        # bzip2 압축
ls -l
bzip2 -d test1.txt.bz2 # bzip2 압축풀기
ls -l
bzip2 -k test1.txt      # bzip2 유지하며 압축
ls -l
gzip test1.txt          # gzip
ls -l
gzip -d test1.txt.gz
ls -l
gzip -k test1.txt
ls -l
zip zipped.zip test1.txt    # zip 압축 (파일명)
ls -l
unzip zipped.zip
ls -l
ls -l
tar cf tartar.tar test1.txt test2.txt   # 파일 묶기
ls -l
tar cvf tartar2.tar test1.txt test2.txt 
ls -l
tart cvfz test1.txt test2.txt 
tar cvfz mytar.tar.gz test1.txt test2.txt 
ls -l
tar xf tartar.tar       # 파일 묶기 해제
ls -l
tar xvf tartar.tar 
ls -l
rm test1.txt test2.txt 
ls -l
tar xvf tartar.tar
ls -l
tar xvfz mytar.tar.gz 
ls -l
rm test1.txt test2.txt 
ls -l
tar xvfz mytar.tar.gz 
ls -l
tar cvfj system.tar.xz /etc/systemd/
ls -l
tar xfj system.tar.xz
ls
ls etc
ls etc/systemd/
mkdir newdir
tar Cxfj newdir system.tar.xz   # 지정 디렉토리에 파일 묶기 해제
ls newdir/
ls
# 파일 찾기 find, which, whereis
find -name "test*"              # test로 시작하는 파일명 찾기
find /etc -name "*.conf"        # /etc폴더에서 확장자가 conf인 파일명 찾기
cd ~
ls
ls -l
find -user root                 # 사용자가 root인 파일 찾기
find -user ubuntu
find /home -user ubuntu
find ~ -perm 644                # 권한이 읽고쓰기인 파일 찾기
ls -l
find ~ -perm 755
find -size +10k
find -size +10024k              
find -size +10000k              # 10Mb보다 큰 파일 찾기
find -size -1k                  # 1kb보다 큰 파일 찾기
history
find -name "t*"
find -size +10000k

which gzip              # 패키지 경로 확인
cd /usr/bin/gzip
cd /usr/bin/
ls gzip
ls -l gzip
which bzip2
whereis gzip            # 패키지, 소스, 매뉴얼 경로 확인

# 주기적 자동 수행 cron
gedit /etc/crontab      # 크론 설정 파일 편집
nano /etc/crontab
systemctl status cron   # 크론 서비스 상태 보기
nano /etc/crontab
pwd
cd
pwd
touch myBackup.sh       # 파일 생성
ls -l myBackup.sh 
chmod 755 myBackup.sh   # 실행 권한 부여
ls -l myBackup.sh 
nano myBackup.sh 
ls /backup
mkdir /backup           # 백업폴더 만들기
ls myBackup.sh 
./myBackup.sh 
ls /backup/
systemctl restart cron  # cron 서비스 재시작
timedatectl set-ntp 0   # 수동 날짜 변경 설정
date 011503002023       # 날짜 및 시간 변경
ls /backup
date 021503002023
ls /backup

# 일회성 예약 at
at
apt -y install at rdate     # rdate, at 패키지 설치
rdate
at
rdate -s time.bora.net      # 타임서버로 표준 시간대 설정
at
at 4:00 am tomorrow         # 내일 4시 일회성 예약
at -l                       # 목록 확인
atrm 1                      # 1회성 예약 삭제
at -l