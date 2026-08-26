import { useState } from 'react'
import './investor_form.css'

function InvestorForm({ onBack }) {
  const [formData, setFormData] = useState({ name: '', country: '', website: '' })
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
    <main className="investor-page">
      <header className="investor-topbar">
        <button className="back-button" type="button" onClick={onBack} aria-label="Back to module selection">← <span>Back</span></button>
        <a className="brand" href="/" aria-label="Zires home"><span className="brand-mark">Z</span><span>ZIRES</span></a>
        <span className="secure-status"><span className="status-dot" /> Secure portal</span>
      </header>
      <section className="investor-content">
        <div className="investor-intro">
          <div className="eyebrow"><span /> Join the network</div>
          <h1>Make an<br /><em>impact.</em></h1>
          <p>Tell us about your organization and connect with the ideas shaping what comes next.</p>
        </div>
        <form className="investor-form" onSubmit={handleSubmit}>
          <div className="form-heading"><span className="investor-form-icon" aria-hidden="true">◈</span><div><span className="module-label">INVESTOR REGISTRATION</span><h2>Organization details</h2></div></div>
          <label htmlFor="investor-name">Name<input id="investor-name" name="name" type="text" value={formData.name} onChange={handleChange} placeholder="Enter your name" required /></label>
          <label htmlFor="investor-country">Country<input id="investor-country" name="country" type="text" value={formData.country} onChange={handleChange} placeholder="Enter your country" required /></label>
          <label htmlFor="investor-website">Website<input id="investor-website" name="website" type="url" value={formData.website} onChange={handleChange} placeholder="https://yourwebsite.com" required /></label>
          <button className="investor-submit" type="submit">{isSubmitted ? 'Details saved' : 'Register as investor'}<span aria-hidden="true">→</span></button>
          {isSubmitted && <p className="investor-success" role="status">Thanks, {formData.name}. Your investor registration is ready.</p>}
          <p className="form-note"><span className="tiny-check">✓</span> Your information is encrypted and secure</p>
        </form>
      </section>
      <footer className="footer"><span>© 2026 Zires</span><span className="footer-line" /><span>Built for bold ideas</span></footer>
    </main>
  )
}

export default InvestorForm
