
import "../globals.css"
function Page(){
    let title ="자료실";
    let ar1 = ['자바 바이블 예제',"스프링 용어집",'AI 활용'];
    let date =['2025-09-01','2025-09-02','2025-09-03'];
    let item = [
        { name: "자바 바이블 예제", date: "2025-09-01" ,imag: "/images/book1.png"},
        { name: "스프링 용어집", date: "2025-09-02",imag: "/images/book2.png"},
        { name: "AI 활용", date: "2025-09-03",imag: "/images/book3.png" }
    ];
    return(
        <div>
            <h1 className="title">{title}</h1>
            <hr/>
            {/* ar1이라는 배열의 요소들을 data라는 변수에 전달하면서
                반복하는 문장 */}
            {
                // ar1.map(fun~)
                item.map(function(item,i){
                    return(
                        <div className="box" key={i}>
                            <header>
                            {/* <h4>{data}</h4>
                            <p>{date[i]}</p> */}
                            <h4>{item.name}</h4>
                            <p>{item.date}</p>
                            </header>
                            <div>
                            {/* <img src={item.imag} alt={item.name} className="box-img"/> */}
                            <img src={`/images/book${i+1}.png`} className="box-img"/>
                            </div>
                        </div>
                    );
                })
            }
        </div>
    );
}

export default Page;