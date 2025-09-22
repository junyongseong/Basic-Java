import Link from "next/link";

export default function BbsTR(item) { //만약 여기 이름이 props면 전부 props로 바꾸면 ok
  return (
    <tr>
      <td>{item.b_idx}</td>{/* 여기를 만약이름을 바꾸고 싶으면 bbs/page.js에서 넘겨주는 이름을 바꾸면 ok */}
      <td>
        <Link href={`bbs/${item.b_idx}`}>
        {item.title}
        </Link>
        </td>
      <td>{item.writer}</td>
      <td>{item.reg_date}</td>{/* 예시로 여길 reg_date로 바꿔보면?
                                page.js에서 reg_date={item.write_date} 이렇게*/}
      <td>{item.hit}</td>
    </tr>
  );
}
