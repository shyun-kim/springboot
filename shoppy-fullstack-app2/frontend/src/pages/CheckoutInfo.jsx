import React, { useContext, useState } from 'react'
import { useLocation } from 'react-router-dom'
import "../styles/cart.css";
import "../styles/checkoutinfo.css";
import { CartContext } from '../context/CartContext';

export function CheckoutInfo() {
    const { cartList, totalPrice } = useContext(CartContext);

    return (
        <div className='cart-container'>
            <h2 className='cart-header'>주문/결제</h2>
            {/* 구매자 정보 */}
            <div className='section'>
                <h2 className='section-title'>구매자정보</h2>
                <div className='info-box'>
                    <div className='info-grid'>
                        <div className='label'>이름</div>
                        <div className='value'>홍길동</div>
                        
                        <div className='label'>이메일</div>
                        <div className='value'>hong@naver.com</div>
                        
                        <div className='label'>휴대폰 번호</div>
                        <div className='value phone-input'>
                            <input type="text" value={"010-1234-1234"}/>
                            <button className='btn'>수정</button>
                        </div>
                    </div>
                </div>
            </div>
            {/* 받는사람 정보 */}
            <div className='section'>
                <h2 className='section-title'>
                    받는 사람 정보&nbsp;&nbsp;&nbsp;
                    <button>배송지 변경</button>
                </h2>
                <div className='info-box'>
                    <div className='info-grid'>
                        <div className='label'>이름</div>
                        <div className='value'>홍길동</div>
                        
                        <div className='label'>배송주소</div>
                        <div className='value'>12345 / 서울시 강남구 역삼동 123</div>

                        <div className='label'>연락처</div>
                        <div className='value'>010-1234-1234</div>

                        <div className='label'>배송 요청사항</div>
                        <div className='value phone-input'>
                            <input type="text" defaultValue="문 앞"/>
                            <button className='btn'>변경</button>
                        </div>
                    </div>
                </div>
            </div>

            {/* 주문 정보 */}
            <div className='section'>
                <h2 className='section-title'>주문 상품</h2>
                <div className='info-box'>
                    <div className='info-grid'>
                        {cartList && cartList.map(item => 
                            <>
                                <div className='label'>상품명</div>
                                <div className='value'>
                                    <img src={item.image} alt="product image" style={{width:'35px'}} />
                                    {item.name}, {item.info}, 수량({item.qty}), 가격({item.price.toLocaleString()}원)
                                </div>
                            </>
                        )}
                    </div>
                </div>
            </div>

            <div className="section">
                <h2>결제정보</h2>
                <table className="payment-tabel">
                    <tr>
                        <td>총상품가격</td>
                        <td className='price'>{totalPrice.toLocaleString()}원</td>
                    </tr>
                    <tr>
                        <td>즉시할인</td>
                        <td className='discount'>-0원</td>
                    </tr>
                    <tr>
                        <td>할인쿠폰</td>
                        <td className='coupon'>
                            0원 <span className='info'>적용 가능한 할인 쿠폰이 없습니다.</span>
                        </td>
                    </tr>
                    <tr>
                        <td>배송비</td>
                        <td className='price'>0원</td>
                    </tr>
                    <tr>
                        <td>쿠페이캐시</td>
                        <td className='price'>
                            0원 <span className='info'>보유: 0원</span>
                        </td>
                    </tr>
                    <tr className='total'>
                        <td>총결제금액</td>
                        {/* <td class="total-price">{totalPrice.toLocaleString()}원</td>  */}
                        {/* 윗 줄이 주석 처리되어 있었음 왜인지는 모름 */}
                    </tr>
                </table>
            </div>

            <div className='section'>
                <h2>결제 수단</h2>
                <div className='payment-method'>
                    <label className='radio-label'>
                        <input type="radio" name='payment' checked /> 카카오페이
                        <span className='badge'>최대 캐시적립</span>
                    </label>
                </div>

                <div className='payment-method'>
                    <label className='radio-label'>
                        <input type="radio" name='payment' /> 쿠페이 머니
                    </label>
                </div>

                <div className='payment-method'>
                    <label className='radio-label'>
                        <input type="radio" name='payment' /> 
                        다른 결제 수단 <span className='arrow'>▼</span>
                    </label>
                </div>
            </div>

            <div className='terms'>
                <input type="checkbox" id="terms" />
                <label for="terms">구매조건 확인 및 결제대행 서비스 약관 동의</label>
                <br />
                <input type="checkbox" id="privacy" />
                <label for='privacy'>개인정보 국외 이전 동의</label>
            </div>
            
            <button className='pay-button'>결제하기</button>
        </div>
    );
}
