import React, { useEffect, useState, useRef } from "react";
import axios from "axios";

export default function App() {
  const [results, setResults] = useState([]);
  const [query, setQuery] = useState("react hooks");
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);

  useEffect(() => {
    getResults();
  }, []);

  const serachInputRef = useRef();

  const getResults = async () => {
    setLoading(true);

    try {
      const response = await axios.get(
        `http://hn.algolia.com/api/v1/search?query=${query}`
      );
      setResults(response.data.hits);
      setLoading(false);
      setError("");
    } catch (err) {
      setError(err);
    }
  };

  const handleSearch = (event) => {
    event.preventDefault();
    getResults();
  };

  const handleClearSearch = (event) => {
    setQuery("");
    serachInputRef.current.focus();
  };

  return (
    <div className="container max-w-md mx-auto p-4 m-2 bg-purple-50 shadow-lg rounded">
      <h1 className="text-grey-darker text-3xl">Hooks news</h1>
      <form onSubmit={handleSearch} className="mb-2">
        <input
          type="text"
          value={query}
          onChange={(event) => setQuery(event.target.value)}
          ref={serachInputRef}
          className="border p-1 rounded"
        ></input>
        <button type="submit" className="bg-yellow-500 rounded m-1 p-1">
          Search
        </button>
        <button
          className="bg-green-500 text-white p-1 rounded"
          type="button"
          onClick={handleClearSearch}
        >
          Clear
        </button>
      </form>
      {loading ? (
        <div className="text-orange">Loading results ...</div>
      ) : (
        <ul className="list-reset leading-normal">
          {results.map((result) => (
            <li key={result.objectID}>
              <a
                className="text-indigo-dark hover:bg-red-700"
                href={result.url}
              >
                {result.title}
              </a>
            </li>
          ))}
        </ul>
      )}

      {error && <div className="text-red font-bold">{error.message}</div>}
    </div>
  );
}
