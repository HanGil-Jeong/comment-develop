![header](https://capsule-render.vercel.app/api?type=waving&color=auto&height=250&section=header&text=걷기반%20댓글CRUD%20과제&fontSize=65)

## 개요
- Srping Boot, Spring Data JPA와 MySQL을 사용하여 일정 생성 어플에 댓글 기능과 대댓글 기능을 추가하였고 일정 목록 조회 시 댓글 개수도 함께 조회되고 댓글에 대댓글을 작성할 수 있습니다.

## 개발 환경
언어 : ![Static Badge](https://img.shields.io/badge/Java-red?style=flat-square)

JDK : ![Static Badge](https://img.shields.io/badge/JDK-17-yellow?style=flat-square)

프레임워크 : ![Static Badge](https://img.shields.io/badge/SpringBoot-%23FFFF00?logo=springboot)

DB : ![Static Badge](https://img.shields.io/badge/MySql-%23FFFFFF?style=flat&logo=mysql)

ORM : ![Static Badge](https://img.shields.io/badge/JPA-FFA500?style=flat)

## 🔠 목차

1. [API 명세서](#-api-명세서)
2. [ERD](#-erd)
3. [기능 요약](#-기능-요약)
4. [디렉토리 구조](#-디렉토리-구조)

# API 명세서
![](https://github.com/HanGil-Jeong/comment-develop/blob/main/screencapture-teamsparta-notion-site-1e62dc3ef51480d59883cd948780ff96-2025-05-14-10_58_28.png?raw=true)

# ERD
![](https://d2sqqdb3t4xrq5.cloudfront.net/upload/cYNBivDMJDrD6KvEK/Q1FhQ0NMODZDTGMyNjRyZXpfYWdINjhibkxmcWNnaGs1cE4ucG5n)

# 기능 요약
- 일정 CRUD
    - 일정 생성 
    - 일정 목록 조회 시 댓글 갯수 함께 조회
    - 일정 단일 조회 시 댓글 함께 조회
    - 일정 수정
    - 일정 삭제
- 댓글 CRUD
    - 댓글 생성
    - 댓글 목록 조회
    - 댓글 단일 조회 시 대댓글 함께 조회
    - 댓글 수정
    - 댓글 삭제
- 대댓글 CRUD
    - 대댓글 생성
    - 대댓글 목록 조회 시 부모댓글 함께 조회
    - 대댓글 수정
    - 대댓글 삭제

# API 동작
![](https://teamsparta.notion.site/image/attachment%3A810f149a-256d-474c-bca7-69c99dd0b2bd%3A%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7_2025-05-14_111049.png?table=block&id=1f32dc3e-f514-809f-af80-cde6b6ac6e08&spaceId=83c75a39-3aba-4ba4-a792-7aefe4b07895&width=750&userId=&cache=v2)
![](https://teamsparta.notion.site/image/attachment%3Aafcd93c5-669f-4f16-92d0-6a89d364d40c%3A%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7_2025-05-14_111035.png?table=block&id=1f32dc3e-f514-802e-bffd-d2ec6049826c&spaceId=83c75a39-3aba-4ba4-a792-7aefe4b07895&width=750&userId=&cache=v2)
![](https://teamsparta.notion.site/image/attachment%3Af2425830-a473-4320-b6fc-5dd49962057f%3A%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7_2025-05-14_111207.png?table=block&id=1f32dc3e-f514-803e-9a4d-c09b5aa44ed3&spaceId=83c75a39-3aba-4ba4-a792-7aefe4b07895&width=750&userId=&cache=v2)
![](https://teamsparta.notion.site/image/attachment%3Ac91ce98e-49f9-4940-ab6b-70caba763d43%3A%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7_2025-05-14_111218.png?table=block&id=1f32dc3e-f514-8030-9262-e50962928bc1&spaceId=83c75a39-3aba-4ba4-a792-7aefe4b07895&width=750&userId=&cache=v2)
![](https://teamsparta.notion.site/image/attachment%3A88347312-2e64-4b00-8afb-8699b9b4d604%3A%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7_2025-05-14_111322.png?table=block&id=1f32dc3e-f514-80db-93ea-e7d122465a67&spaceId=83c75a39-3aba-4ba4-a792-7aefe4b07895&width=750&userId=&cache=v2)

