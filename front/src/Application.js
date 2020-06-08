import React, { useContext } from 'react';
import { LoginContext } from './providers/LoginProvider'

import Login from './Login';
import Main from './Main';
import { BrowserRouter as Router } from 'react-router-dom';

export default function Application() {
    const user = useContext(LoginContext);
    return (

        !user ? <Login /> :
            <Router >
                <Main />
            </Router >

    );
}