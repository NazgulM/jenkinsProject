import unittest
from app import app
class TestApp(unittest.TestCase):
    def setUp(self):
        self.client = app.test_client()
    def tearDown(self):
        pass
    def test_homepage(self):
        response = self.client.get('/')
        self.assertEqual(response.status_code, 200)
        self.assertEqual(response.data.decode('utf-8'), 'Hello, World!')
if __name__ == '__main__':
    unittest.main()