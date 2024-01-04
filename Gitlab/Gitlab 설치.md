# Gitlab 설치

<aside>
💡 Ubuntu 22.04 버전에서 설치했습니다.
  
</aside>

### apt update

```bash
sudo apt-get update 
```

### gitlab 의존성 설치

```bash
sudo apt-get install -y curl openssh-server ca-certificates tzdata perl
```

### Postfix 설치

```bash
sudo apt install postfix
```

### gitlab ce 설치


```bash
 curl https://packages.gitlab.com/install/repositories/gitlab/gitlab-ce/script.deb.sh | sudo bash
```

```bash
sudo EXTERNAL_URL="https://gitlab.example.com" apt-get install gitlab-ce
```


### gitlab.rb 수정

![스크린샷 2023-11-27 170026](https://github.com/kd0547/Learning/assets/86393702/05e06473-c8a2-429f-a446-a32bb49a02bd)

`http 사용` : external_url ‘http://gitlab.local.co.kr’

`https 사용` : external_url ‘https://gitlab.local.co.kr

<aside>
💡 만약, 다른 포트 번호를 사용하고 싶으면 URL 뒤에 포트 번호를 추가하면 된다. 
ex) https://gitlab.local.co.kr:9090

</aside>



### letsencrypt 설정

![스크린샷 2023-11-27 170431](https://github.com/kd0547/Learning/assets/86393702/b8cf4ffa-10f7-4431-8210-faa71d4c383a)


`https` 를 사용할려면 ssl 인증서를 발급받아야한다. gitlab에서는 무료 공인 인증서 발급이 가능하다  

### nginx dedirect설정

![스크린샷 2023-11-27 170932](https://github.com/kd0547/Learning/assets/86393702/4fc59aab-5c8f-456d-bc70-05ae566156fa)

해당 설정은 `http` → `https` 로 리다이렉트를 해주는 설정이다. 

<aside>
💡 다른 포트 번호를 사용한 경우, 변경한 포트 번호에 맞춰서 값을 변경해야한다. 
ex) https://gitlab.local.co.kr:9090 이면, nginx['redirect_http_to_https_port'] = 9090

</aside>

### gitlab 재시작

```bash
sudo gitlab-ctl reconfigure
```

### gitlab 관리자 root 비밀번호 변경

gitlab을 설치하면 관리자 비밀번호를 변경해야한다.  비밀번호는 gitlab을 설치하고 24시간 동안 유지되며, 이후에는 비밀번호 파일이 삭제된다.

```bash
sudo cat /etc/gitlab/initial_root_password | grep Password
```
