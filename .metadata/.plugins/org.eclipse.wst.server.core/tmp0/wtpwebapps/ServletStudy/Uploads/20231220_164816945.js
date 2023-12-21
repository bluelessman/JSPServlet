
export default function TailCard({ imgSrc, title, subtitle, tags }) {
  return (
    <div>
      <div>
        <img src={imgSrc} alt={title} />
      </div>
      <div className="space-y-8 text-5xl text-shadow-lg font-bold text-gray-900 dark:text-white shadow-red-500/50">
        {title}
      </div>
      <div>
        {subtitle}
      </div>
      <div>
        {tags}
      </div>
    </div>
  )
}
