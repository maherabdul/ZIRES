import { useState } from 'react'
import RegistrationUser from './RegistrationUser.jsx'
import InvestorForm from './investor_form.jsx'
import './Menu.css'

function Menu() {
  const [selectedModule, setSelectedModule] = useState('user')
  const [showRegistration, setShowRegistration] = useState(false)
  const [showInvestorForm, setShowInvestorForm] = useState(false)

  const modules = [
    { id: 'user', label: 'USER', title: 'Explore your workspace', description: 'Access your projects, track progress, and bring ideas to life.', accent: 'blue' },
    { id: 'investor', label: 'INVESTOR', title: 'Shape what comes next', description: 'Discover opportunities, review performance, and invest with clarity.', accent: 'navy' },
  ]

  const handleContinue = () => {
    if (selectedModule === 'user') {
      setShowRegistration(true)
      return
    }
    setShowInvestorForm(true)
    return
  }

  if (showRegistration) {
    return <RegistrationUser onBack={() => setShowRegistration(false)} />
  }

  if (showInvestorForm) {
    return <InvestorForm onBack={() => setShowInvestorForm(false)} />
  }

  return (
    <main className="portal">
      <header className="topbar">
        <a className="brand" href="/" aria-label="Nexora home"><span className="brand-mark">Z</span><span>ZIRES</span></a>
        <span className="secure-status"><span className="status-dot" /> Secure portal</span>
      </header>
      <section className="hero-section">
        <div className="eyebrow"><span /> Welcome back</div>
        <h1>Choose your<br /><em>perspective.</em></h1>
        <p className="intro">One platform. Two ways to move forward.<br />Select the space that is right for you.</p>
        <div className="module-grid" role="group" aria-label="Choose a module">
          {modules.map((module) => (
            <button className={`module-card ${module.accent} ${selectedModule === module.id ? 'selected' : ''}`} type="button" key={module.id} onClick={() => { setSelectedModule(module.id); if (module.id === 'user') setShowRegistration(true); if (module.id === 'investor') setShowInvestorForm(true) }} aria-pressed={selectedModule === module.id}>
              <div className="card-topline"><span className="module-label">{module.label}</span><span className="selection-indicator" aria-hidden="true">{selectedModule === module.id ? '✓' : ''}</span></div>
              <div className="module-icon" aria-hidden="true">{module.id === 'user' ? '↗' : '◈'}</div>
              <div className="card-copy"><h2>{module.title}</h2><p>{module.description}</p></div>
              <span className="card-arrow" aria-hidden="true">→</span>
            </button>
          ))}
        </div>
        <button className="continue-button" type="button" onClick={handleContinue}>Continue as {selectedModule === 'user' ? 'User' : 'Investor'}<span aria-hidden="true">→</span></button>
        <p className="selection-note"><span className="tiny-check">✓</span> Your selection can be changed anytime</p>
      </section>
      <footer className="footer"><span>© 2026 Zires</span><span className="footer-line" /><span>Built for bold ideas</span></footer>
    </main>
  )
}

export default Menu
