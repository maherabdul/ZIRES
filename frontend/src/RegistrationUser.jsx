import { useState } from 'react'
import './RegistrationUser.css'

function RegistrationUser({ onBack }) {
  const [formData, setFormData] = useState({ fullName: '', email: '', password: '' })
  const [isSubmitted, setIsSubmitted] = useState(false)

  const handleChange = (event) => {
    const { name, value } = event.target
    setFormData((currentData) => ({ ...currentData, [name]: value }))
  }

  const handleSubmit = (event) => {
    event.preventDefault()
    setIsSubmitted(true)
  }

  return (
    <main className="registration-page">
      <header className="registration-topbar">
        <button className="back-button" type="button" onClick={onBack} aria-label="Back to module selection">← <span>Back</span></button>
        <a className="brand" href="/" aria-label="Zires home"><span className="brand-mark">Z</span><span>ZIRES</span></a>
        <span className="secure-status"><span className="status-dot" /> Secure portal</span>
      </header>
      <section className="registration-content">
        <div className="registration-intro">
          <div className="eyebrow"><span /> Create your account</div>
          <h1>Start your<br /><em>journey.</em></h1>
          <p>Join Zires and unlock a workspace designed to help your ideas move forward.</p>
        </div>
        <form className="registration-form" onSubmit={handleSubmit}>
          <div className="form-heading"><span className="form-icon" aria-hidden="true">↗</span><div><span className="module-label">USER REGISTRATION</span><h2>Your details</h2></div></div>
          <label htmlFor="fullName">Full name<input id="fullName" name="fullName" type="text" value={formData.fullName} onChange={handleChange} placeholder="Enter your full name" required /></label>
          <label htmlFor="email">Email address<input id="email" name="email" type="email" value={formData.email} onChange={handleChange} placeholder="you@example.com" required /></label>
          <label htmlFor="password">Password<input id="password" name="password" type="password" value={formData.password} onChange={handleChange} placeholder="Create a password" minLength="8" required /></label>
          <button className="register-button" type="submit">{isSubmitted ? 'Account details saved' : 'Create user account'}<span aria-hidden="true">→</span></button>
          {isSubmitted && <p className="success-message" role="status">Thanks, {formData.fullName}. Your registration is ready.</p>}
          <p className="form-note"><span className="tiny-check">✓</span> Your information is encrypted and secure</p>
        </form>
      </section>
      <footer className="footer"><span>© 2026 Zires</span><span className="footer-line" /><span>Built for bold ideas</span></footer>
    </main>
  )
}

export default RegistrationUser
