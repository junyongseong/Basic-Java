export default function List(){
    let title = "방명록";
    let item = [
        {sub:"글제목1", date: "1월 1일",content:"본문 나와라"},
        {sub:"글제목2", date: "2월 2일",content:"나와라!!"},
        {sub:"글제목3", date: "3월 3일",content:"나와라 얍"}
    ];

    return (
        <div>
            <h1 className="title">{title}</h1>
            <hr/>
            <div className="list-bg">
            {
                item.map((item, i) => (
                    <div className="list-item" key={i}>
                        <h4>{item.sub}</h4>
                        <p>{item.date}</p>
                        <p>{item.content}</p>
                        <hr/>
                    </div>
                ))
            }
            </div>
        </div>
    );
}
