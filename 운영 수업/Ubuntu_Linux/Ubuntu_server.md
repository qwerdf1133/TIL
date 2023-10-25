# 리눅스 종료 명령
poweroff
shutdown -P now
halt -p
init 0

# shutdown 옵션
shutdown -P +10  # 10분 후 종료
shutdown -r 22:00 # 오후 10시에 재부팅(-r)
shutdown -c        # 예약된 종료 취소
shutdown -k +15 # 종료 메시지는 보내지만 실제로 종료하지 않음

# 가상 콘솔 사용하기
ctrl + alt + f2~f7

# 런 레벨(Run level)
init 0 : 런 레벨을 0으로 설정
0 : Power off 종료 모드
1 : Rescue / 시스템 복구 모드
2 ~ 4 : 텍스트 다중 사용자 모드
5 : 그래픽 모드
6 : Reboot / 재부팅

# 이전 명령어 보기
- 위 아래 화살표로 이전 명령 확인 가능
- history : 이전 전체 명령 확인 가능
- history -c : 기록 지우기

# 자동완성
- tab : 자동완성 
- 동일한 이름이 있을시 tab 2회 누르면 같은 이름 후보가 표시됨

# 편집기 (editor)
1. gedit (그래픽 환경)
2. nano
3. vi
   - 입력모드 i(insert) or a(append)
   - 명령모드 (입력모드, 라인모드에서 esc키)
   - 라인명령모드 : (좌측하단에 명령 표시)
      - :q 종료
      - :wq 저장후종료
      - :q! 강제종료

# 입력모드 진입
- i 현재커서에서 입력	I 커서줄 앞에서 입력 <br/>
- a 다음칸부터 입력 		A 커서줄 마지막 입력 <br>
- o 다음줄에 입력    	O 이전 줄에 입력    
- s 한글자 지우고 입력	S 한 줄 지우고 입력

# 방향 이동
 h(왼쪽)j(아래)k(위)l(오른쪽)

# 페이지 이동
 Ctrl + F 다음화면	Ctrl + B 이전화면

# 행 처음, 마지막 이동
 ^ 행 처음으로 $ 행 마지막으로

# 행 이동
 gg 첫 행
 G 끝 행
 10G 숫자 줄(10번째줄)
 :10  10번째줄
 
# 복사
dd 한 줄 삭제 3d 여러줄 삭제
yy 한 줄 복사 p 붙여넣기
3y 여러줄 복사
라인모드
/단어 (단어찾기) n 다음 단어

# 장치 mount 하기
- 물리적, 가상CD 삽입
- mount 명령어로 마운트 위치 확인
- mount 위치 지정
- mount /dev/cdrom [마운트할 위치]
- mount /dev/cdrom media/cdrom
- 장치 마운트 해제
- umount [해지할장치]
- umount /dev/cdrom
12:17
가상 이미지만들기
dpkg --get-selections genisoimage
genisoimage -r -J -o boot.iso /boot

# 리눅스 기본 명령어

1. ls
 - list 목록의 약자로 디렉토리 및 파일 나열
    - -a : 숨김파일 표시
     - -l : 자세하게 보기
2. pwd
 - Print Working Directory : 현재 디렉토리 전체 경로
3. cd
 - Change Directory : 디렉토리 이동
    - cd .. (상대경로 : 상위 디렉토리)
    - cd /디렉토리명 (절대경로 : 루트 기준)
    - cd ~ (사용자의 홈 디렉토리)
4. cp
  - CoPy 파일 또는 디렉토리 복사
     - cp [복사할파일명] [복사될파일명]
     - cp -r [복사할디렉토리] [복사될디렉토리]
5. touch
  - 파일 생성(새파일) 또는 수정시간 변경(기존파일)
6. mv
  - MoVe
     - 이름 변경 : mv [기존파일명] [바꿀파일명]
     - 이동 : mv [기존 파일경로] [이동할디렉토리명]
     - 여러 파일 이동 : mv [이동할파일1] ... [이동할디렉토리명]
7. rm
  - ReMove
  - 디렉토리 삭제시 rm -r [디렉토리명]
8. mkdir
  - MaKeDir
  - mkdir -p /상위/부모/디렉토리   부모디렉토리도 생성
9. rmdir
  - ReMoveDir
    - 빈 디렉토리만 삭제가능
10. cat
  - conCatenate 연결
  - cat [파일명] : 파일 내용을 보여준다.
  - cat [파일1] [파일2] ... : 파일 내용을 연결해서 보여준다.
11. head / tail
  - 텍스트 파일의 앞 10줄만 출력한다.
  - head [파일명]
  - head -5 [경로명] : 앞에서 5줄만
  - tail -3 [경로명] : 끝에서 3줄만
11. more / less
  - more [경로명] 페이지 단위로 확인
  - less [경로명] : more의 확장
12. file [경로명] : 파일의 타입을 확인 가능

# 사용자와 그룹
/etc/passwd : 리눅스에 존재하는 사용자 정보 확인
	사용자이름:암호:uid:gid:추가정보:home:shell
/etc/group : 그룹 정보 확인
	그룹이름:암호:gid:그룹에속한사용자
/etc/shadow : 암호정보가 암호화되어 추가

adduser [사용자] 추가
	--uid [uid] [유저명 ] 사용자아이디지정 생성
passwd [사용자] 비밀번호 변경

usermod 사용자 속성 변경
	--shell [변경할속성] [유저명]
	--group [변경할속성] [유주명]
userdel [사용자] 삭제
chage 비밀번호 주기 설정
	-l [사용자명] 암호 주기 설정 확인
	-M [일수] [사용자명] 암호 최대사용일
groups 소속된 그룹 확인
groupadd 새로운 그룹 생성
	[그룹명]
groupmod 그룹 속성 변경
	--new-name [바꿀그룹명] [이전그룹명]
groupdel [그룹명] 그룹 삭제

# Ownership 소유권
해당 파일 또는 디렉토리를 소유한 사용자와 그룹명
chown [변경할사용자명] [경로명]
chown ubuntu sample
chgrp [변경할그룹명] [경로명]
chgrp ubuntu sample
chown [변경할사용자명.그룹명] [경로명]
chown ubuntu.ubuntu sample

# Permission 허가권
rwx / rwx / rwx
소유자 		/ 소유그룹	 / 그외사용자
읽기/쓰기/실행 /	읽기/쓰기/실행 	/ 읽기/쓰기/실행

chmod 777 [경로명]   - 전체 실행가능
chmod 644 [경로명]  - 사용자만 쓰기, 나머지 읽기 가능
chmod u+x [경로명] - 유저만 실행권한 획득
---
파일유형 / 파일 허가권 / 링크 수 / 소유권 / 크기 / 변경시간 / 파일이름
-rw-r--r-- 1 root root 0 10월 18 14:58 sample

십진수  4 2 1  =>  7(10)
이진수  1 1 1

이진수  1 0 1   => 5(10)
이진수  1 0 0   => 4(10)
           1 1 0   => 6(10)

rw-r--r--
110 / 100 / 100  => 644

# 사용자 변경
su (Switch User)
su [계정명]
su - [계정명] / 홈디렉토리까지 전환
whoami : 사용자 이름 확인
exit : su 로 변경한 이전계정 복귀