import React, {useState} from 'react'
import axios from 'axios'

function SignIn() {

    const [formData, setFormData] = useState({
            email: '',
            password: ''
        });

    const handleChange = (e) => {
        const {name, value} = e.target;
        setFormData({
            ...formData,
            [name]: value
        });
    };
    
    const handleSubmit = async (e) => {
            e.preventDefault();
    
            try {
                const response = await axios.post('http://localhost:8080/api/users/sign-in', formData);
    
                if (response.status === 200) {
                    alert('환영합니다.');
                    console.log('로그인한 유저 정보: ', response.data);
                }
            } catch (error) {
                console.log('실패: ', error);
                alert('로그인 중 실패');
            }
        }

    return (
        <div style={styles.container}>
            <h2>ArtistSpace 로그인</h2>
            <form onSubmit={handleSubmit} style={styles.form}>
                <input type="email" name="email" placeholder="이메일" onChange={handleChange} required style={styles.input} />
                <input type="password" name="password" placeholder="비밀번호" onChange={handleChange} required style={styles.input} />
                
                <button type="submit" style={styles.button}>로그인하기</button>
            </form>
        </div>
    )
}

const styles = {
    container: { maxWidth: '400px', margin: '50px auto', textAlign: 'center', padding: '20px', border: '1px solid #ddd', borderRadius: '10px' },
    form: { display: 'flex', flexDirection: 'column' },
    input: { margin: '10px 0', padding: '10px', fontSize: '16px', borderRadius: '5px', border: '1px solid #ccc' },
    label: { fontSize: '12px', textAlign: 'left', color: '#666', marginTop: '10px' },
    button: { padding: '12px', backgroundColor: '#1DA1F2', color: 'white', border: 'none', borderRadius: '5px', cursor: 'pointer', fontWeight: 'bold' }
};

export default SignIn
