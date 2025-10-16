
import { Outlet } from 'react-router-dom';
import {Header} from '../components/commons/Header.jsx'
import {Footer} from '../components/commons/Footer.jsx'

export function Layout({cartCount}) {
    return (
        <>
            <Header cartCount={cartCount} />
            <Outlet />
            <Footer />
        </>
    )
}