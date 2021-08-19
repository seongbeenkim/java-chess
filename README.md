# java-chess 게임

## 구현해야할 목록

- [] 입력
  - [x] 시작 여부 입력
- [] 출력
  - [x] 체스판 전체 출력

- [ ] 체스게임(ChessGame)
  - [x] 체스판
  - [] 현재 플레이어
  - [x] 게임 시작&종료 상태 제어

  - 기능
    - [x] 명령어 검증 및 처리
      - [x] start : 게임 실행
      - [x] end : 게임 종료
      - [] move : 인자로 전달받은 source 위치에서 target 위치로 기물 이동

- [x] 체스판(Board)
  - [x] 체스판
  - [x] 생성 시 32개의 기물 초기화

  - 기능
    - [x] 인자로 전달받은 위치에 기물이 있는지 확인
      - [x] ERROR : 존재하지 않을 경우
      - [x] 같은 색상 기물인지 확인
        - [x] ERROR : 다른 색상일 경우
      - [x] 시작과 도착 위치의 기물이 다른 색상인지 확인
        - [x] ERROR : 같은 색상일 경우
      - [x] source 위치에서 target 위치로 기물 이동
        - [x] ERROR : source 위치에 기물이 없는 경우
        - [x] ERROR : 자신의 기물이 아닌 경우
        - [x] ERROR : source, target 위치의 기물 색상이 같을 경우
        - [x] ERROR : source, target 위치가 같을 경우
        - [x] ERROR : 이동 경로에 기물이 존재할 경우

- [x] 기물(Piece)
  - [x] 색상

  - [x] 기물 위치(Position)
    - [x] 파일
    - [x] 랭크
    - [x] 64개의 캐싱된 위치

    - 기능
      - [x] 전달받은 인자에 해당하는 위치 객체 반환

  - [x] 기물 색상(Color)
    - [x] 색상

  - [x] 기물 이름 매퍼
    - [x] 기물 종류에 따라 이름을 매핑


## 이동 규칙

- [x] 폰 (1 or 0.5)
  - [x] 적 방향 직선 1칸 이동
    - [x] ERROR : 직선 방향 2칸 이상일 경우
    - [x] ERROR : 좌, 우 이동이 포함될 경우
  - [x] 처음 이동 시에는 2칸 이동 가능
    - [x] ERROR : 직선 방향 3칸 이상일 경우
    - [x] ERROR : 좌, 우 이동이 포함될 경우

  - [x] 공격 : 적 방향 좌, 우 대각선 1칸
    - [x] ERROR : 직선 1칸 && 좌 또는 우 1칸이 아닐 경우

- [x] 룩 (5)
  - [x] 모든 직선 방향으로 원하는 만큼 이동 가능
    - [x] ERROR : 룩 이동 패턴으로 이동할 수 없는 위치일 경우

- [x] 나이트 (2.5)
  - [x] 모든 직선 방향 1칸 + 이동한 직선 방향의 좌, 우 대각선 1칸으로 이동 가능
    - [x] ERROR : 나이트 이동 패턴으로 이동할 수 없는 위치일 경우
  - [x] 진행 방향이 가로막혀도 적, 아군 상관없이 뛰어넘을 수 있다.

- [x] 비숍 (3)
  - [x] 모든 대각선 방향으로 원하는 만큼 이동 가능
    - [x] ERROR : 비숍 이동 패턴으로 이동할 수 없는 위치일 경우

- [x] 퀸 (9)
  - [x] 모든 방향 1칸 + α 이동 (모든 대각선 방향으로는 원하는 만큼 이동 가능)
    - [x] ERROR : 퀸 이동 패턴으로 이동할 수 없는 위치일 경우

- [x] 킹
  - [x] 모든 방향 1칸 이동
    - [x] ERROR : 킹 이동 패턴으로 이동할 수 없는 위치일 경우
  - [ ] 상대의 공격 범위로는 이동 불가능

