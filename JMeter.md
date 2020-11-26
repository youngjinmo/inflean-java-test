# JMeter

성능 측정 및 부하(load) 테스트 기능을 제공하는 오픈 소스 자바 애플리케이션

- [생활코딩 - JMeter를 이용해서 웹 서버 성능 테스트하기](https://www.youtube.com/watch?v=1AyxqIePusA&list=WL&index=2)

## What is JMeter

**다양한 웹 테스트 지원**

- 웹 - HTTP, HTTPS
- SOAP / REST 웹 서비스
- FTP
- 데이터베이스 (JDBC 사용)
- Mail (SMTP, POP3, IMAP)

**CLI 지원**

- CI 또는 CD 툴과 연동할 때 편리함
- UI 사용하는 것보다 메모리 등 시스템 리소스를 적게 사용

**주요 개념**

- **Thread Group** : 한 쓰레드당 유저 한 명
- **Sampler** : 어떤 유저가 해야 하는 액션
- **Listener** : 응답을 받았을 때 할 일 (리포팅, 검증, 그래프 그리기)
- **Configuration** : Sampler 또는 Listener가 사용할 설정 값 (Cookie, JDBC connection)
- **Assertion** :  응답이 성공적인지 확인하는 방법 (응답 코드, 본문 내용)

<br>

## How to install

[Apache JMeter](https://jmeter.apache.org/download_jmeter.cgi)에 접속해서 Binaries 하단의 zip 파일을 설치하고, 이를 압축해제한다.

<br>

## How to run

설치한 경로로 가서 `\bin` 디렉토리 하위에 가서 jmeter를 실행해준다.

**Mac**

```
cd bin\
.\jmeter
```

**Windows**

```
cd bin\
.\jmeter
```

여기서 주의해야할 점은 <span style="color: red;">성능 테스트할 애플리케이션이 도는 서버와 JMeter를 실행하는 서버가 같으면 안된다.</span> JMeter가 실행되면서 테스트 대상 애플리케이션과 동일한 시스템 리소스를 사용할 경우 서로 서버에 부하를 가할 수 있기 때문에 정확한 성능 테스트를 할 수 없다. 따라서 서로 서버환경을 분리해서 테스트해야한다.

<br>

### Create Test Plan

![](https://user-images.githubusercontent.com/33862991/100198494-46ab2b00-2f3f-11eb-914e-d2cfca0a6cc9.JPG)

<br>

### Create Thread Group

![](https://user-images.githubusercontent.com/33862991/100199053-fd0f1000-2f3f-11eb-8223-db4e609804a4.JPG)

![](https://user-images.githubusercontent.com/33862991/100198505-47dc5800-2f3f-11eb-8edf-c87717f41241.JPG)

**Number of Threads (users)** : 쓰레드의 갯수

**Ramp-up period (seconds)** : 이 쓰레드들을 설정하는 시간. (몇초만에 설정할지)

**Loop Count** : 반복 회수 (Infinite 체크시 무한반복)

<br>

### Create HTTP Request

![](https://user-images.githubusercontent.com/33862991/100199055-fe403d00-2f3f-11eb-8781-e15993ce1c96.JPG)

![](https://user-images.githubusercontent.com/33862991/100199273-4e1f0400-2f40-11eb-87c3-4515e33767c5.JPG)

<br>

### Listener  생성하기 (성능결과 보기)

**[Thread Group]** 에서 Listener를 클릭하면, **View Results Tree**, **View Results in Table**, **Summary Report**, **Aggregate Report** 를 추가한다.

![](https://user-images.githubusercontent.com/33862991/100199056-fed8d380-2f3f-11eb-9a91-c321e9286d1f.JPG)

성능테스트를 할 대상 웹 애플리케이션을 실행하고, JMeter를 실행한다.

![](https://user-images.githubusercontent.com/33862991/100199875-2b411f80-2f41-11eb-8870-344e5f184b35.JPG)

웹 서버를 실행하고, JMeter까지 실행했다면 아까 Listener로 실행한 View Results Tree를 들어가면 아래와 같은 화면처럼 요청에 따른 성능 테스트 결과를 받아 볼 수 있다.

![](https://user-images.githubusercontent.com/33862991/100200601-321c6200-2f42-11eb-9159-157a029e13c3.JPG)

**Min** : 최소 요청 수
**Max** : 최대 요청수
**Throughput** : 초당 실행되는 요청 수

이걸 그래프로 보는 방법도 있다.

**[Listener]** 에서 **[Response Time Graph]** 추가하고, 아래 화면에서 **[Display Graph]** 클릭하면, 초당 통신속도를 그래프로 볼 수 있다.

![](https://user-images.githubusercontent.com/33862991/100208219-d35be600-2f4b-11eb-8c2b-4997f4446d7e.JPG)

![](https://user-images.githubusercontent.com/33862991/100208229-d48d1300-2f4b-11eb-9474-da57708caa79.JPG)

<br>