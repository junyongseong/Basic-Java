import NoticeTR from "@/components/noticeTR";
export default function bbs(){
    let subject =['가을이 온다','봄이 온다','리액트 어렵다'];
    let item=[{subject : "가을이 온다.",writer: "백길동", date:"2025-09-13"},
        {subject : "봄이 온다.",writer: "감길동", date:"2025-09-14"},
        {subject : "리액트 어렵다.",writer: "굼길동", date:"2025-09-15"}
    ];
    return(
        <div>
            <h1 classNmae="title">공지사항</h1>
            <hr/>
            <div>
                <table className="t1">
                    <thead>
                        <tr>
                            <th>번호</th>
                            <th>제목</th>
                            <th>글쓴이</th>
                            <th>등록일</th>
                            <th>조회수</th>
                        </tr>
                    </thead>
                    <tbody>
                        {/* 다음은 Componet를 활용한 예시이다. 나중에 반복처리 map사용해서 연습해보기 */}
                        {/* <NoticeTR subject={subject[0]} writer ="백길동"/>
                        <NoticeTR subject={subject[1]} writer ="감길동"/>
                        <NoticeTR subject={subject[2]} writer ="굼길동"/> */}
                        {
                        item.map(function(item,i){
                            return(
                            <NoticeTR Key={i+1} subject={item.subject} writer={item.writer} date={item.date}/>
                            );
                        })
                        }
                    </tbody>
                </table>
            </div>
        </div>
    );
};