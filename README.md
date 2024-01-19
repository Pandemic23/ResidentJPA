# 증명서 발급 시스템 문서

## 주민등록등본

- **설명:**
    - 주민등록등본은 주민등록 주소지를 같이 하는 세대의 세대주와 세대원이 기재됩니다.
    - 가족관계라도 동일 세대에 포함되지 않으면 주민등록등본에 나오지 않고, 타인이라도 동일 세대에 포함되면 주민등록등본에 나오게 됩니다.
    - 주민등록등본은 세대주 기준으로 출력되므로, 세대주와 세대원의 출력 결과가 동일합니다.

## 가족관계증명서

- **설명:**
    - 가족관계증명서는 본인을 기준으로 가족관계가 있는 '본인, 배우자, 부모, 자녀'가 기재됩니다.
    - 가족이라고 하더라도 기준이 되는 사람에 따라서 기재사항이 다르고, 형제자매는 기록되지 않습니다.

## 출생신고서

- **설명:**
    - 출생신고서는 신생아의 출생을 신고하기 위해 작성하는 가족관계등록 문서입니다.
    - 출생신고는 일생에 한번만 작성합니다.

## 사망신고서

- **설명:**
    - 사람의 사망 사실을 행정 기관에 알리기 위한 문서입니다.
    - 사망신고는 일생에 한번만 작성합니다.

## 기타 요구사항

### 가족관계 및 세대구성

- 가족관계와 세대구성은 관리하는 목적이 다르므로, 분리하여 관리해야 합니다.

### 세대주

- 한 사람이 동시에 여러 세대의 세대주가 될 수 없습니다.
- 세대주는 배우자에 한해 변경이 가능하고, 이 때, 세대구성원의 세대주 관계에 입력된 '본인'과 '배우자'가 바뀝니다.

### 세대구성원

- 출생신고 시 가족관계 및 세대구성원에 자동으로 등록되며, 세대구성원의 변동사유를 '출생등록'으로 입력합니다.

### 증명서확인번호

- 증명서확인번호는 발급된 가족관계증명서, 주민등록등본 문서를 식별하는 문서로, 16자리의 번호로 구성되어 있습니다.

### 증명서발급

- 가족관계증명서, 주민등록등본 발급 시 신청한 주민과 증명서확인번호, 증명서발급일자만 관리하고, 각 증명서의 스냅 샷 정보는 관리하지 않습니다.

### 신고인

- 출생신고서와 사망신고서의 신고인은 필요 시 확인을 위해 반드시 관리해야 합니다.