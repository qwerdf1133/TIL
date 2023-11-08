cd

# 파티션 설정하기
ls -l /dev/sd*
fdisk /dev/sdb
ls -l /dev/sd*
fdisk /dev/sdc
ls -l /dev/sd*
fdisk /dev/sdd
fdisk /dev/sde
fdisk /dev/sdf
fdisk /dev/sdg
fdisk /dev/sdh
fdisk /dev/sdi
fdisk /dev/sdj
ls -l /dev/sd*

# mdadm 설치하기
apt -y install mdadm
mdadm
mdadm --help
init 0
cd 
fdisk -l /dev/sdb
fdisk -l /dev/sdc

# 레이드(리니어 레이드) 생성하기
mdadm --create /dev/md9 --level=linear --raid-devices=2 /dev/sdb1 /dev/sdc1
mdadm --detail --scan
mkfs.ext4 /dev/md9
mkdir /raidLinear
mount /dev/md9 /raidLinear/
df
nano /etc/fstab
mdadm --detail /dev/md9

# 레이드(RAID 0) 생성하기
mdadm --create /dev/md0 --level=0 --raid-devices=2 /dev/sdd1 /dev/sde1
mdadm --detail --scan
ls /dev/md*
mdadm --detail /dev/md0
df
mkfs.ext4 /dev/md0
mkdir /raid0
mount /dev/md0 /raid0
df
df | grep /dev/md
nano /etc/fstab

# 레이드(RAID 1) 생성하기
mdadm --create /dev/md1 --level=1 --raid-devices=2 /dev/sdf1 /dev/sdg1
mkfs.ext4 /dev/md1
mkdir /raid1
mount /dev/md1 /raid1
nano /etc/fstab
df | grep /dev/md
mdadm --detail /dev/md1

# 레이드(RAID 5) 생성하기
mdadm --create /dev/md5 --level=5 --raid-devices=3 /dev/sdh1 /dev/sdi1 /dev/sdj1
mdadm --detail -scan
mkfs.ext /dev/md5
mkfs.ext4 /dev/md5
mkdir /raid5
mount /dev/md5 /raid5
df | grep /dev/md
nano /etc/fstab

# mdadm.conf 설정파일 등록(버그)
mdadm --detail --scan
ls /dev/md*
nano /etc/mdadm/mdadm.conf 
mdadm --detail --scan
nano /etc/mdadm/mdadm.conf 
init 6
ls /dev/md*
update-initramfs 
update-initramfs -u
df
ls /dev/md*
update-initramfs -u
reboot
ls /dev/md*
df
df | grep /dev/md
ls /dev/md*
nano /etc/mdadm/mdadm.conf 

# 임의 파일 각 raid에 복사
ls /raidLinear/
ls /raid0
ls /raid1
ls /raid5
nano testFile
ls -l testFile 
cp testFile /raid0
cp testFile /raid1
cp testFile /raid5
cp testFile /raidLinear/
ls /raidLinear/
cp testFile /raid0
ls /raid0
ls /raid1
ls /raid5
df | grep /dev/md
shutdown
shutdown now

# 고장 확인
ls -l /dev/sd*
df
mdadm --detail --scan
mdadm --run /dev/md1
mdadm --detail --scan
mount /dev/md1 /raid1
df | grep /dev/md
ls /raid0
ls /raid5
ls /raid1
nano testFile 
mdadm --detail /dev/md1
mdadm --run /dev/md5
mdadm --detail --scan
ls /raid5
mount /dev/md5 /raid5
ls /raid5
nano testFile 
mdadm --detail /dev/md5
mdadm --run /dev/md9
mdadm --run /dev/md0
mdadm --stop /dev/md0
mdadm --stop /dev/md9
nano /etc/fstab
halt -p
