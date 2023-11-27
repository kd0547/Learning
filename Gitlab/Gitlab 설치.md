# Gitlab 설치

<aside>
💡 Ubuntu 22.04 버전에서 설치했습니다.

</aside>

### apt update

```bash
sudo apt update
sudo apt upgrade -y
```

### Postfix 설치

```bash
sudo apt install postfix
```

### gitlab 의존성 설치

```bash
sudo apt install -y ca-certificates curl openssh-server
```

### gitlab.rb 수정

![Untitled](Gitlab%20%E1%84%89%E1%85%A5%E1%86%AF%E1%84%8E%E1%85%B5%20637052cf5f3f498f9aebfed015995a2d/Untitled.png)

`http 사용` : external_url ‘http://gitlab.local.co.kr’

`https 사용` : external_url ‘https://gitlab.local.co.kr

<aside>
💡 만약, 다른 포트 번호를 사용하고 싶으면 URL 뒤에 포트 번호를 추가하면 된다. 
ex) https://gitlab.local.co.kr:9090

</aside>

### letsencrypt 설정

![Untitled](Gitlab%20%E1%84%89%E1%85%A5%E1%86%AF%E1%84%8E%E1%85%B5%20637052cf5f3f498f9aebfed015995a2d/Untitled%201.png)

`https` 를 사용할려면 ssl 인증서를 발급받아야한다. gitlab에서는 무료 공인 인증서 발급이 가능하다  

### nginx dedirect설정

![Untitled](Gitlab%20%E1%84%89%E1%85%A5%E1%86%AF%E1%84%8E%E1%85%B5%20637052cf5f3f498f9aebfed015995a2d/Untitled%202.png)

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