import {
  Button,
  Pagination,
  Paper,
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow,
} from "@mui/material";
import { useRouter } from "next/navigation";


export default function BbsList({ ar, tp, cp }) {

    // navigation라우터임
    const router =useRouter();
  return (
    <TableContainer component={Paper}>
      <Table sx={{ minWidth: 650 }}>
        <TableHead>
          <TableRow>
            <TableCell>번호</TableCell>
            <TableCell>제목</TableCell>
            <TableCell>글쓴이</TableCell>
            <TableCell>등록일</TableCell>
            <TableCell>조회수</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {ar.map((row, i) => (
            <TableRow
              key={i}
              sx={{ "&:last-child td, &:last-child th": { border: 0 } }}
            >
              <TableCell component="th" scope="row" align="left">
                {row.b_idx}
              </TableCell>
              <TableCell align="left">{row.subject}</TableCell>
              <TableCell align="left">{row.writer}</TableCell>
              <TableCell align="left">{row.write_date}</TableCell>
              <TableCell align="left">{row.hit}</TableCell>
            </TableRow>
          ))}
          {/* 반복문의 끝 */}
          {/* 다음은 페이징 기법을 위한 행의 하나 추가되어야한다. */}
          <TableRow>
            <TableCell colSpan={4}>
              <Pagination count={tp} color="primary" onChange={cp} />
            </TableCell>
            <TableCell>
              {/*
              <Link href="board/write"
              <Button 여기다가 링크를 거는게 아니라
                variant="contained"
                color="primary"
                onClick={function () {
                  //현재 글쓰기 버튼을 클릭할 때마다 수행하는 곳!!
                }}
              >
                글쓰기
              </Button>
              </Link>/}*/}
              <Button
                variant="contained"
                color="primary"
                onClick={function () {
                  //현재 글쓰기 버튼을 클릭할 때마다 수행하는 곳!!
                  //Link :이동할 페이지의 경로가 정해진 경우 사용 정적.. 그대신 빠름
                  //router.push : 동적 이동 하기전에 뭔가 할일이 있다면 즉 조건 또는
                  // 구현되는 로직에 따라 경로가 정해져야할때 if로그인여부
                  router.push("/board/write");
                }}
              >
                글쓰기
              </Button>
            </TableCell>
          </TableRow>
        </TableBody>
      </Table>
    </TableContainer>
  );
}
