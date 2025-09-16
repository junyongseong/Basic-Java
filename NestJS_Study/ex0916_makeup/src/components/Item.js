import { Button } from "@mui/material";
import styles from "./css/Item.module.css";

// 여기서 파라미터 이름은 props가 아닌 item이다~ page.js에서 item이란 이름으로 넣어줌
export default function Item(props) {
    const {
    id,
    name,
    image_link,
    price,
    description,
    updated_at,
    category,
    product_type,
    product_link,
  } = props.item; // 인자로 넘어온 item객체를 저장한다.

    return (
    <>
    <div className={styles.wrap}>
        <div className={styles.ing_item}>
        <img src={image_link} alt={name} className={styles.img_item} />
        </div>
        <div className={styles.info_item}>
            <strong className={styles.tit_item}>{name}</strong>
            <strong className={styles.num_price}>${price}</strong>
            <span className={styles.txt_int}>
            {/* 카테고리가 있을때는 출력하고 없으면 공백 출력
                삼항 연산자 사용 있으면 카테고리 없으면 공백 출력 */}
            {category ? `${category}/` : ""}
            {product_type}
        </span>
        <Button variant="contained" color="error">
            구매하기
        </Button>
        </div>
    </div>
    </>
);
}
